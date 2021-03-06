package com.cpe.backend.repository;

import com.cpe.backend.entity.Register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  


@RepositoryRestResource
public interface RegisterRepository extends JpaRepository<Register, Long> {
    Register findById(long id);
}