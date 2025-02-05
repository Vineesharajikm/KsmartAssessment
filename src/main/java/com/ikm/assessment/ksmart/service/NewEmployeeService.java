package com.ikm.assessment.ksmart.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ikm.assessment.ksmart.config.ModelMapperConfig;
import com.ikm.assessment.ksmart.contract.EmployeeDTO;
import com.ikm.assessment.ksmart.model.Employee;
import com.ikm.assessment.ksmart.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewEmployeeService {
    private final EmployeeRepository repo;
    private final ModelMapperConfig config;
     public List<Map<String, Object>> getEmployeeByByDesignation(String designation) {
        
        return repo.findByDesignation(designation);
    }

    public List<EmployeeDTO> getSalaryBetweenFromDb() {
        List<Employee> details = repo.findBySalaryBetween("25000", "50000");
        List<EmployeeDTO> responseList = details.stream()
            .map(employee -> config.mapper().map(employee, EmployeeDTO.class))
            .collect(Collectors.toList());
        return responseList;
    }
}
