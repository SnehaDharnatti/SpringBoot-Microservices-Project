package com.example.HotelService.service;


import com.example.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {


    // create
    Hotel saveHotel(Hotel hotel);

    List<Hotel> getHotels();

    Hotel getById(String id);


//    getAll




//    get single



}
