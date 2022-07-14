package com.example.onlinevoting.dto;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;
@Data
public class CandidateAllDto {
    private Long candidateId;
    private double gpa;
    private String image;
    private Long student_id;
    private Long position_id;
}

