package com.se.dummytempmonitorbackend.notification;

public class SmsNotification implements NotificationManager{
    @Override
    public int sender() {
        System.out.println("Sms Send it");
        return 1;
    }
}
