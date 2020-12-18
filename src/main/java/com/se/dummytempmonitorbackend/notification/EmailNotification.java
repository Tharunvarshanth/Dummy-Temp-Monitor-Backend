package com.se.dummytempmonitorbackend.notification;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailNotification implements NotificationManager{

    @Autowired

    @Override
    public int sender() {
        System.out.println("Email send it");
        return 1;
    }
}
