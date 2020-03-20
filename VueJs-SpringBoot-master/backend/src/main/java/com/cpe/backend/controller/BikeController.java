package com.cpe.backend.controller;


import com.cpe.backend.entity.Bike;
import com.cpe.backend.repository.BikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BikeController {

    @Autowired
    private final BikeRepository bikeRepository;

    public BikeController(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @GetMapping("/bike")
    public Collection<Bike> Bikes() {
        return bikeRepository.findAll().stream().collect(Collectors.toList());
    }

    

}