package com.se.dummytempmonitorbackend.service;

import com.se.dummytempmonitorbackend.entities.sensormock.SensorMock;
import com.se.dummytempmonitorbackend.entities.sensormock.SensorMockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorMockRepository extends JpaRepository<SensorMock, SensorMockId> {

    @Query("from SensorMock  as s where s.sensor_id=:sensor_id")
    List<SensorMock> findAllBySensor_id(@Param("sensor_id") String sensor_id);
    //List<SensorMock>  findSensorMocksBySensor_id(String sensor_id);
}
