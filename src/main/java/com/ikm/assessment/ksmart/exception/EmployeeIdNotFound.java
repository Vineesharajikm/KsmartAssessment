package com.ikm.assessment.ksmart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeIdNotFound extends RuntimeException {
    public EmployeeIdNotFound(){
        super("id not found");
    }
    
}
