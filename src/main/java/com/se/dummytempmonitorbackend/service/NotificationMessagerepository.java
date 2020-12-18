package com.se.dummytempmonitorbackend.service;

import com.se.dummytempmonitorbackend.entities.notification.NotificationMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationMessageRepository extends JpaRepository<NotificationMessage,String> {

    @Query("from NotificationMessage as n where n.sensor_id=:sensor_id")
    List<NotificationMessage> findAllBySensor_id(@Param("sensor_id") String sensor_id);
}
