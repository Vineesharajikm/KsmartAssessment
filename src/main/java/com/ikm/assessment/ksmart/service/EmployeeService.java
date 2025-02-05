package com.ikm.assessment.ksmart.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.ikm.assessment.ksmart.config.ModelMapperConfig;
import com.ikm.assessment.ksmart.contract.EmployeeDTO;
import com.ikm.assessment.ksmart.exception.EmployeeIdNotFound;
import com.ikm.assessment.ksmart.model.Employee;
import com.ikm.assessment.ksmart.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repo;
    private final ModelMapperConfig config;

    public Employee saveNewEmployee(EmployeeDTO request) {
        Employee model=config.mapper().map(request,Employee.class);

        return repo.save(model);
    }

    public List<Employee> getAllEmployeeFromDb() {
      return repo.findAll();
    }

    public Optional<Employee> getEmployeeByIdFromDb(Integer id) {
        Optional<Employee> model=repo.findById(id);
        return model;
    }

    public Employee updateEmployeeByIdFromDb(EmployeeDTO request, Integer id) {
       Employee model=repo.findById(id).orElseThrow(()->new EmployeeIdNotFound());
       config.mapper().map(request,model);
        
       return repo.save(model);
    }

    public Employee deleteEmployeeByIdFromDb(Integer id) {
        Optional<Employee> employeeOptional = repo.findById(id);
        
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            repo.deleteById(id);
            return employee; 
        }
                return null;
    
}

    // public List<Map<String, Object>> getEmployeeByByDesignation(String designation) {
        
    //     return repo.findByDesignation(designation);
    // }

    // public List<EmployeeDTO> getSalaryBetweenFromDb() {
    //     List<Employee> details = repo.findBySalaryBetween("25000", "50000");
    //     List<EmployeeDTO> responseList = details.stream()
    //         .map(employee -> config.mapper().map(employee, EmployeeDTO.class))
    //         .collect(Collectors.toList());
    //     return responseList;
    // }

}
