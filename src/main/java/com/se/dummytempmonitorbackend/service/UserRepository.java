package com.se.dummytempmonitorbackend.service;

import com.se.dummytempmonitorbackend.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {


    User findUserByEmailAndAndPassword(String email,String password);
}
