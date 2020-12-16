package com.se.dummytempmonitorbackend.service;

import com.se.dummytempmonitorbackend.entities.SensorMock;
import com.se.dummytempmonitorbackend.entities.SensorMockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorMockrepository extends JpaRepository<SensorMock, SensorMockId> {

}
