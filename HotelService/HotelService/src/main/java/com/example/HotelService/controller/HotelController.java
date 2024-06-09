package com.example.HotelService.controller;


import com.example.HotelService.entity.Hotel;
import com.example.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
       Hotel hotel1 =  hotelService.saveHotel(hotel);
       return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/getHotel")
    public ResponseEntity<List<Hotel>> getHotels(){
        List<Hotel> getAll = hotelService.getHotels();
        return ResponseEntity.status(HttpStatus.OK).body(getAll);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id) {
        Hotel getAll = hotelService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(getAll);
    }


}
