package com.example.RatingService.controller;


import com.example.RatingService.entity.Rating;
import com.example.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

      @Autowired
      private RatingService ratingService;
//    create
//    get all ratingd
//    get all by userid
//    get all by hotelid

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
       Rating rating1 =  ratingService.saveRating(rating);
       return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> rating2 = ratingService.getAll();
        return  ResponseEntity.ok(rating2);

    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        List<Rating> rating3 = ratingService.getByUserId(userId);
        return  ResponseEntity.ok(rating3);
    }


    @GetMapping("/getByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        List<Rating> rating3 = ratingService.getByHotelId(hotelId);
        return  ResponseEntity.ok(rating3);
    }



}
