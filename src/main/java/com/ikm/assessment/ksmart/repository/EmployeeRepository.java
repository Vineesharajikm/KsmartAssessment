package com.ikm.assessment.ksmart.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ikm.assessment.ksmart.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    Optional<Employee> findById(Integer id);
    
    @Query(nativeQuery = true, value = """
Select * from tr_employee where designation=:designation
    
            """)
    List<Map<String, Object>> findByDesignation(@Param("designation") String designation);

    List<Employee> findBySalaryBetween(String From,String to);
}
