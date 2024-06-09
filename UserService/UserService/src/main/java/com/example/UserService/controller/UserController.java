package com.example.UserService.controller;

import com.example.UserService.entity.User;
import com.example.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody  User user){
       User user1 = userService.saveUSer(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }
    @GetMapping("/ ")
    public ResponseEntity<List<User>> getAllUsers(){
       List<User> user2 = userService.getAllUser();
        return  ResponseEntity.status(HttpStatus.OK).body(user2);
    }

    @GetMapping("/getId/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable  String userId){
       User allUser = userService.getUser(userId);
        return  ResponseEntity.status(HttpStatus.OK).body(allUser);
    }


}
