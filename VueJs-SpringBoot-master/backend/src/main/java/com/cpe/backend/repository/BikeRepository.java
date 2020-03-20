package com.cpe.backend.repository;

import com.cpe.backend.entity.Bike;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  

@RepositoryRestResource  
public interface BikeRepository extends JpaRepository<Bike, Long> {

    Bike findById(long id);
    
}