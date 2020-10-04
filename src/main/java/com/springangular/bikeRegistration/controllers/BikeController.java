package com.springangular.bikeRegistration.controllers;

import com.springangular.bikeRegistration.entities.Bike;
import com.springangular.bikeRegistration.services.BikeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {
    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("api/v1/bikes")
    public List<Bike> getAllBikes(){
        return bikeService.findAllBikes();
    }

    @GetMapping("/api/v1/bikes/{id}")
    public Bike getBikeById(@PathVariable("id") long id) {
        return bikeService.getById(id);
    }

    @PostMapping("/api/v1/bikes")
    public void saveBike(@RequestBody Bike bike){
        bikeService.createBike(bike);
    }

    @GetMapping("api/v1/bikes/sellers/{seller}")
    public List<Bike> findBikeBySeller(@PathVariable("seller") String seller){
        return bikeService.findAllBySeller(seller);
    }

}
