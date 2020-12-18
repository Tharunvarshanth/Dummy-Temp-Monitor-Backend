package com.se.dummytempmonitorbackend.controller;


import com.se.dummytempmonitorbackend.entities.user.User;
import com.se.dummytempmonitorbackend.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userrepository;
    public UserController(UserRepository userrepository){
        this.userrepository = userrepository;
    }

    //SIGNUP
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user){

        Optional<User> existing = userrepository.findById(user.getEmail());
        if( existing.isPresent() ){
            return ResponseEntity.ok(null);
        }

        User response =   userrepository.save(user);
        System.out.println("Registraion Successfull"+ ResponseEntity.ok(response));
        return ResponseEntity.ok(response);


    }

    @PostMapping("/signin")
    public ResponseEntity<User> signin(@RequestBody User user){

        User optionalUser = userrepository.findUserByEmailAndAndPassword(user.getEmail(), user.getPassword());
        if(optionalUser!=null){
            System.out.println("Login Successfull"+ ResponseEntity.ok(optionalUser));
            return ResponseEntity.ok(optionalUser);
        }


        return ResponseEntity.ok(null);

    }

}
