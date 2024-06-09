package com.example.UserService.service;

import com.example.UserService.entity.User;

import java.util.List;

public interface UserService {


    //create



    List<User> getAllUser();


    User getUser(String userId);

    User saveUSer(User user);
}
