package com.se.dummytempmonitorbackend.controller;


import com.se.dummytempmonitorbackend.entities.sensormock.SensorMock;
import com.se.dummytempmonitorbackend.service.SensorMockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sensorsmock")
public class SensorMockController {

    @Autowired
    SensorMockRepository sensorMockRepository;

    public SensorMockController(SensorMockRepository sensorMockRepository){
        this.sensorMockRepository = sensorMockRepository;
    }





    @GetMapping("/send_sensor_reads_to_charts")
    public List<SensorMock> send_read_datas(@RequestParam String sensor_id){

        List<SensorMock>  sensorMockList =   sensorMockRepository.findAllBySensor_id(sensor_id);

        return sensorMockList;

    }
}
