package com.se.dummytempmonitorbackend.service;

import com.se.dummytempmonitorbackend.entities.NotificationMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationMessagerepository extends JpaRepository<NotificationMsg,String> {
}
