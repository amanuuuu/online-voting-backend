package com.example.onlinevoting.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CandidateDto {
    private double gpa;
    private String academic_year;
    private Long student_id;
    private Long position_id;
    private String election_id;
    private MultipartFile image;
}
