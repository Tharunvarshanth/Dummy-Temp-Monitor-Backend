package com.se.dummytempmonitorbackend.entities.sensor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sensors")
public class Sensor {
    @Id
    private String id;
    private String threshold;
    public Sensor(String id, String threshold) {
        this.id = id;
        this.threshold = threshold;

    }

    public Sensor() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

}
