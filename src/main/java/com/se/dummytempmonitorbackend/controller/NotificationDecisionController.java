package com.se.dummytempmonitorbackend.controller;

import com.se.dummytempmonitorbackend.entities.notification.NotificationMessage;
import com.se.dummytempmonitorbackend.entities.sensor.Sensor;
import com.se.dummytempmonitorbackend.entities.sensormock.SensorMock;
import com.se.dummytempmonitorbackend.entities.sensormock.SensorMockId;
import com.se.dummytempmonitorbackend.notification.EmailNotification;
import com.se.dummytempmonitorbackend.notification.NotificationManager;
import com.se.dummytempmonitorbackend.notification.SmsNotification;
import com.se.dummytempmonitorbackend.service.NotificationMessageRepository;
import com.se.dummytempmonitorbackend.service.SensorMockRepository;
import com.se.dummytempmonitorbackend.service.SensorRepository;
import com.se.dummytempmonitorbackend.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/")
public class NotificationDecisionController {

    @Autowired
    SensorMockRepository sensorMockRepositary;
    @Autowired
    SensorRepository sensorRepositary;
    @Autowired
    UserRepository userrepository;
    @Autowired
    NotificationMessageRepository notificationMessagerepository;

    NotificationManager notificationManager;

    public NotificationDecisionController(SensorMockRepository sensorMockRepositary , SensorRepository sensorRepositary,  NotificationMessageRepository notificationMessagerepository){
        this.sensorMockRepositary = sensorMockRepositary;
        this.sensorRepositary = sensorRepositary;
        this.notificationMessagerepository = notificationMessagerepository;
    }



    //Get Data from Nifi
    @PostMapping("/getreaddatas")
    public void getreaddatas(@RequestBody SensorMock sensorMock) throws IOException, MessagingException {

        String sensor_device_id = sensorMock.getSensor_id();
        String values_get_date_time = sensorMock.getDate();

                SensorMockId sensorMockId = new SensorMockId(sensor_device_id,values_get_date_time);
         Optional<SensorMock> sensormockoptional = sensorMockRepositary.findById(sensorMockId);

          if(sensormockoptional.isPresent()){
              SensorMock sensorMock1 = sensormockoptional.get();
              String temperature_value = sensorMock1.getData_value() ;

               int number_datavalue = Integer.parseInt(temperature_value.replaceAll("[^0-9.]", ""));

              //Call to get  Particular sensor threshold
              String threshold =  getthreshold_bysensor( sensor_device_id );

                int numberthreshold = Integer.parseInt(threshold.replaceAll("[^0-9.]", ""));


              if( number_datavalue > numberthreshold ){
                  notificationManager = new SmsNotification();
                  List<String> phonelist = userrepository.findAllPhonenumber();
                  notificationManager.sender(phonelist,"Temperature Monitor Alert Generation","Read value:"+temperature_value+"> Threshold value :"+threshold);

                  notificationManager = new EmailNotification();
                  List<String> emaillist = userrepository.findAllEmail();
                  notificationManager.sender(emaillist,"Temperature Monitor Alert Generation","Read value:"+temperature_value+"> Threshold value :"+threshold);

                  //Add Notification TABLE Messages
                  addmsg_todb(sensor_device_id,values_get_date_time,"Read value:"+temperature_value+"> Threshold value :"+threshold );
              }

          }
          else{
              System.out.println("<<<<<<<<<<<<<<<SYSTEM ERROR>>>>>>>>>>>>>>");
          }

    }


   //NotificationMessage Table
    public void addmsg_todb(String sensor_id,String date,String description){

        NotificationMessage notificationMessage = new NotificationMessage(sensor_id,date,description);
        notificationMessagerepository.save(notificationMessage);
    }

    //Sensor Table
    public String getthreshold_bysensor(String sensor_id){

        Optional<Sensor> sensorOptional =  sensorRepositary.findById(sensor_id);
        if (sensorOptional.isPresent()){
            Sensor sensor = sensorOptional.get();
            return sensor.getThreshold();
        }else{
            return null;
        }
    }

}
