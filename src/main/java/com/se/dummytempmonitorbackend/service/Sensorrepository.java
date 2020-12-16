package com.se.dummytempmonitorbackend.service;

import com.se.dummytempmonitorbackend.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sensorrepository extends JpaRepository<Sensor,String> {

}
