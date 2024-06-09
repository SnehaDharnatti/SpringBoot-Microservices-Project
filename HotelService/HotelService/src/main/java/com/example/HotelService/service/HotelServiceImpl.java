package com.example.HotelService.service;

import com.example.HotelService.entity.Hotel;
import com.example.HotelService.exception.ResourceNotFoundException;
import com.example.HotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(String id) {
        return  hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("userId NOT FOUND" + id));
    }


}
