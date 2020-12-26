package com.se.dummytempmonitorbackend.service;

import com.se.dummytempmonitorbackend.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {


    User findUserByEmailAndAndPassword(String email,String password);

    @Query("SELECT  u.email from User as u")
    List<String> findAllEmail();

    @Query("SELECT u.phone_number from User as u")
    List<String>  findAllPhonenumber();
}
