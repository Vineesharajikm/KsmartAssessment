package com.ikm.assessment.ksmart.contract;

import java.util.Date;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    
     @NotEmpty(message="field cannot be empty")
    private String name;

    @NotEmpty(message="field cannot be empty")
    private  String designation;

    @Past
    private Date dateOfBirth;

    @PastOrPresent
    private Date dateOfJoining;

    // @NotEmpty(message="field cannot be empty")
    private String salary;

}
