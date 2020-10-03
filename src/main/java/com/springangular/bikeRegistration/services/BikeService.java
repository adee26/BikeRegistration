package com.springangular.bikeRegistration.services;

import com.springangular.bikeRegistration.entities.Bike;

import java.util.List;

public interface BikeService {
    List<Bike> findAllBikes();
    void createBike(Bike bike);
    Bike getById(long id);
    List<Bike> findAllBySeller(String seller);
}
