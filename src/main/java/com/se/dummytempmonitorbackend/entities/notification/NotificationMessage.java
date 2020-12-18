package com.se.dummytempmonitorbackend.entities.notification;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;




@Entity
@Table(name="notification_msg")
@IdClass(NotificationMessageId.class)
public class NotificationMessage {

    @Id
    private String sensor_id;
    @Id
    private String date;
    private String description;



    public NotificationMessage(String sensor_id, String date, String description) {
        this.sensor_id = sensor_id;
        this.date = date;
        this.description = description;
    }

    public NotificationMessage() {

    }

    public String getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(String sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}

