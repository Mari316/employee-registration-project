package com.cydeo.employeeregistrationproject.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

//    @NotNull            // Except null, anything can be accepted ""
//    @NotEmpty           // Except null and empty String anything can be accepted " " space can be accepted
//    @NotBlank           // Except null, empty String and only space anything can be accepted. At least 1 character besides space



// We have to place those limitations on top of the filed we a re trying to validate
    @NotBlank //(message = "First name can be from 2 to 12 characters only") Error message
    @Size(max = 12, min = 2)//in messages.properties {1} - max, {2} - min
    private String firstName;// {0} always means field(object?)where we want to add validation

    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // we add it otherwise Thymeleaf will fail
    private LocalDate birthday;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

}
