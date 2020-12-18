package com.se.dummytempmonitorbackend.service;

import com.se.dummytempmonitorbackend.entities.sensor.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,String> {


    @Query("SELECT id from Sensor ")
    List<String> findSensorById();
}
