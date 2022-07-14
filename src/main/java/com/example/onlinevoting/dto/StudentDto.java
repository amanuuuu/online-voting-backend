package com.example.onlinevoting.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {
    private Long stdId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String regNo;
    private LocalDate dob;
    private String placeOfBirth;
    private String phoneNumber;
    private String email;
    private String gender;
    private  Long course_id;
    private String username;
    private String password;
}
