package com.example.onlinevoting.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentAllDto {
    private Long std_id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String regNo;
    private LocalDate dob;
    private String placeOfBirth;
    private String phoneNumber;
    private String email;
    private String gender;


}
