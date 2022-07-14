package com.example.onlinevoting.dto;

import lombok.Data;

@Data
public class CourseAllDto {
    private Long courseId;
    private String courseName;
    private Long campus_id;
    private Long faculty_id;
}
