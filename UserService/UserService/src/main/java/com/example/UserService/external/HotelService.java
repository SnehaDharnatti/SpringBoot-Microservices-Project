package com.example.UserService.external;

import com.example.UserService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotel/getId/{hotelId}")
    public Hotel getHotel(@PathVariable String hotelId);

}

