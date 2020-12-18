package com.se.dummytempmonitorbackend.controller;


import com.se.dummytempmonitorbackend.entities.sensor.Sensor;
import com.se.dummytempmonitorbackend.service.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository){
        this.sensorRepository = sensorRepository ;
    }




    @GetMapping("/getsensor_ids")
    public List<String> sendsensorid(){

        List<String> stringList = sensorRepository.findSensorById();
        return stringList;
    }


    @GetMapping("/getthreshold")
    public String getthreshold_bysensor(@RequestParam String sensor_id){

        Optional<Sensor> sensorOptional =  sensorRepository.findById(sensor_id);
        if (sensorOptional.isPresent()){
            Sensor sensor = sensorOptional.get();
            return sensor.getThreshold();
        }else{
            return null;
        }
    }
}
