package com.ikm.assessment.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ikm.assessment.ksmart.contract.EmployeeDTO;
import com.ikm.assessment.ksmart.contract.Response;
import com.ikm.assessment.ksmart.service.NewEmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NewEmployeeController {
    private final NewEmployeeService service;


        @GetMapping("/employees/{designation}")
    public ResponseEntity<?> getEmployeeByDesignation(@PathVariable String designation){
        List<Map<String, Object>> out=service.getEmployeeByByDesignation(designation);

        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(out).message("Delete Sucessfully").build());
    }

    @GetMapping("/salary")
    public ResponseEntity<?> findSalaryBetween(){
      List< EmployeeDTO >out=service.getSalaryBetweenFromDb();

        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(out).message("Delete Sucessfully").build());
    }
}
