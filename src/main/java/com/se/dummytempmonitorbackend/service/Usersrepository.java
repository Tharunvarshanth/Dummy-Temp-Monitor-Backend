package com.se.dummytempmonitorbackend.service;

import com.se.dummytempmonitorbackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usersrepository extends JpaRepository<Users,String> {

}
