
package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Gender;
import com.cpe.backend.repository.GenderRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class GenderController {

    @Autowired
private final GenderRepository genderRepository;

public GenderController(GenderRepository genderRepository){
this.genderRepository = genderRepository;
}

@GetMapping("/gender")
public Collection<Gender>  gender(){
    return genderRepository.findAll().stream().collect(Collectors.toList());
}





}