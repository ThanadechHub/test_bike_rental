package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;
import lombok.Data;

import com.cpe.backend.entity.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Data
@Entity
@NoArgsConstructor
@Table(name="REGISTER")
public class Register {

  
  
   
    @Id
    @Column(name = "NATIONAL_ID", unique = true, nullable = true)
    private  Long nationalID;  
  

    private String name = "";
  


    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "GENDER_ID", insertable = true)
    private Gender gender;

    
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Bike.class)
    @JoinColumn(name = "BIKE_ID", insertable = true)
    private Bike bike; 

}