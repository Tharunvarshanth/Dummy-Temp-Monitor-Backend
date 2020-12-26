package com.se.dummytempmonitorbackend.notification;

import java.util.List;

public class SmsNotification implements NotificationManager{

    @Override
    public int sender(List<String> to, String subject, String description) {
        System.out.println("Sms Send it");
        return 1;
    }
}
