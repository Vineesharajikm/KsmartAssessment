package com.ikm.assessment.ksmart.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tr_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    
 @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tr_employee_seq", allocationSize = 1)
  
    private Integer id;

    private String name;

    private  String designation;

    private Date dateOfBirth;
      
    private Date dateOfJoining;

    private String salary;

    
}
