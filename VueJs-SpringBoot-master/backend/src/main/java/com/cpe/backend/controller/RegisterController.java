package com.cpe.backend.controller;

import com.cpe.backend.entity.Gender;
import com.cpe.backend.repository.GenderRepository;
import com.cpe.backend.entity.Register;
import com.cpe.backend.repository.RegisterRepository;
import com.cpe.backend.entity.Bike;
import com.cpe.backend.repository.BikeRepository;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.net.URLDecoder;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RegisterController{

    @Autowired
    private final RegisterRepository registerRepository;

    @Autowired 
    private GenderRepository genderRepository;

    @Autowired
    private BikeRepository bikeRepository;

    RegisterController(RegisterRepository registerRepository){
            this.registerRepository = registerRepository; 
     }

     
     @GetMapping("/register")
     public Collection<Register> Registers(){        
         return registerRepository.findAll().stream().collect(Collectors.toList());
     }

     @GetMapping("/register/{id}")
     public Optional<Register> Registers(@PathVariable Long id) {
         Optional<Register> register = registerRepository.findById(id);
         return register;
     }

     @RequestMapping(value = "/registerPost",method = RequestMethod.POST)
     public Register newRegister(@RequestBody Map<String, String> body) {
     Register newRegister = new Register();
     Gender Gender = genderRepository.findById(Long.valueOf(body.get("gender")).longValue());
     Bike Bike = bikeRepository.findById(Long.valueOf(body.get("bike")).longValue());
     newRegister.setNationalID(Long.valueOf(body.get("nationalID").toString()));
     newRegister.setName(body.get("name"));
     newRegister.setGender(Gender);
     newRegister.setBike(Bike);
     
     return registerRepository.save(newRegister) ;
    }

  
}

