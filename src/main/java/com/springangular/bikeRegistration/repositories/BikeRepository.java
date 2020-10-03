package com.springangular.bikeRegistration.repositories;

import com.springangular.bikeRegistration.entities.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Long> {
    Bike findById(long id);
    List<Bike> findAllBySeller(String seller);
}
