package com.example.RatingService.service;

import com.example.RatingService.entity.Rating;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingService {


    Rating saveRating(Rating rating);

    List<Rating> getAll();

    List<Rating> getByUserId(String userId);

    List<Rating> getByHotelId(String hotelId);
}
