package com.springangular.bikeRegistration.services;

import com.springangular.bikeRegistration.entities.Bike;
import com.springangular.bikeRegistration.repositories.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService{
    private final BikeRepository bikeRepository;

    public BikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public List<Bike> findAllBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public void createBike(Bike bike) {
        bikeRepository.save(bike);
    }

    @Override
    public Bike getById(long id) {
       return bikeRepository.findById(id);
    }

    @Override
    public List<Bike> findAllBySeller(String seller) {
        return bikeRepository.findAllBySeller(seller);
    }
}
