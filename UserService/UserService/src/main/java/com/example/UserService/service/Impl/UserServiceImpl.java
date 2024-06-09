package com.example.UserService.service.Impl;

import com.example.UserService.entity.Hotel;
import com.example.UserService.entity.Rating;
import com.example.UserService.entity.User;
import com.example.UserService.exception.ResourceNotFoundException;
import com.example.UserService.external.HotelService;
import com.example.UserService.repository.UserRepository;
import com.example.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUSer(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user =userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found" + userId));
//fetching rating from ratingservice
        Rating[] object = restTemplate.getForObject("http://RATINGSERVICE/rating/getByUserId/"+user.getUserId(), Rating[].class);
         logger.info("{}",object);
       List<Rating> ratings = Arrays.stream(object).toList();

         List<Rating> ratingList = ratings.stream().map(rating -> {
//             ResponseEntity<Hotel> forEntity =restTemplate.getForEntity("http://HOTELSERVICE/hotel/getId/"+rating.getHotelId(), Hotel.class);
              Hotel hotel= hotelService.getHotel(rating.getHotelId());
//              logger.info("response status code {}",forEntity);
              rating.setHotel(hotel);
              return rating;

         }).collect(Collectors.toList());

         user.setRating(ratingList);
        return user;
    }


}
