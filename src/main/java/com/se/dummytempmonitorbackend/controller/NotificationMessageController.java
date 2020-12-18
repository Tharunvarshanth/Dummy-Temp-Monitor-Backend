package com.se.dummytempmonitorbackend.controller;


import com.se.dummytempmonitorbackend.entities.notification.NotificationMessage;
import com.se.dummytempmonitorbackend.service.NotificationMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/notify")
public class NotificationMessageController {

    @Autowired
    NotificationMessageRepository notificationMessageRepository ;

    public NotificationMessageController(NotificationMessageRepository notificationMessageRepository){
        this.notificationMessageRepository = notificationMessageRepository ;
    }

    @GetMapping("/get_messages_by_sensor_id")
    public List<NotificationMessage> send_messages_by_sensor_id(@RequestParam String sensor_id){

        List<NotificationMessage> notificationMessageList = notificationMessageRepository.findAllBySensor_id(sensor_id);
        return notificationMessageList;
    }

}
