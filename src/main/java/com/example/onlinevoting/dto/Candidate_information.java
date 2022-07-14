package com.example.onlinevoting.dto;

import lombok.Data;

import java.util.Date;


public interface Candidate_information {
    Long getCandidate_id();
    String getImage();
    double getGpa();
    String getReg_no();
    String getFirst_name();
    String getLast_name();
    String getMiddle_name();
    String getGender();
    String getCourse_name();
    String getFaculty_name();
    String getCampus_name();
    String getPosition_name();
}
