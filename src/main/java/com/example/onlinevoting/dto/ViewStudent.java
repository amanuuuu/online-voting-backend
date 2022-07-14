package com.example.onlinevoting.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


public interface ViewStudent {
    Long getStd_id();
    Long getCourse_id();
    LocalDate getDob();
    String getEmail();
    String getFirst_name();
    String getGender();
    String getLast_name();
    String getMiddle_name();
    String getPhone_number();
    String getPlace_of_birth();
    String getReg_no();
    String getCourse_name();
    String getFaculty_name();
    String getCampus_name();

}
