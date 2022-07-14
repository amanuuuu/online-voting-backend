package com.example.onlinevoting.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long std_id;
    private String regNo;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dob;
    private String placeOfBirth;
    private String phoneNumber;
    private String email;
    private String gender;
    private boolean voted_president;
    private boolean voted_prime_minister;
    private  Long course_id;
    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Candidate> candidateList;



}
