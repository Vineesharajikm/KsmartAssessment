package com.ikm.assessment.ksmart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ikm.assessment.ksmart.contract.EmployeeDTO;
import com.ikm.assessment.ksmart.contract.Response;
import com.ikm.assessment.ksmart.model.Employee;
import com.ikm.assessment.ksmart.service.EmployeeService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
private final EmployeeService service;    

@PostMapping("/employees")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeDTO request){
     Employee out=service.saveNewEmployee(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(Response.builder().payload(out).message("New Employee Created Sucessfully").build());
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployee(){
     List<Employee> out=service.getAllEmployeeFromDb();

        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(out).build());
    }


    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id){
     Optional<Employee> out=service.getEmployeeByIdFromDb(id);

        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(out).build());
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployeeById(@Valid @RequestBody EmployeeDTO request,@PathVariable Integer id){
     Employee out=service.updateEmployeeByIdFromDb(request,id);

        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(out).message("Update Sucessfully").build());
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Integer id){
     Employee out=service.deleteEmployeeByIdFromDb(id);

        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(out).message("Delete Sucessfully").build());
    }
    // @GetMapping("/employees/{designation}")
    // public ResponseEntity<?> getEmployeeByDesignation(@PathVariable String designation){
    //     List<Map<String, Object>> out=service.getEmployeeByByDesignation(designation);

    //     return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(out).message("Delete Sucessfully").build());
    // }

    // @GetMapping("/salary")
    // public ResponseEntity<?> findSalaryBetween(){
    //   List< EmployeeDTO >out=service.getSalaryBetweenFromDb();

    //     return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(out).message("Delete Sucessfully").build());
    // }


}
