package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="BIKE")
public class Bike {

    @Id
    @SequenceGenerator(name="BIKE_seq",sequenceName="BIKE_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="BIKE_seq")  
    @Column(name = "BIKE_ID", unique = true, nullable = true)
    private  Long id;


    @Getter @Setter
    private  String title;

    @OneToMany(fetch = FetchType.LAZY)
    // mappedBy  = "video"
    private Collection<Register> register;


}