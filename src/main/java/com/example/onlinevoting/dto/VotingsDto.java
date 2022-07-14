package com.example.onlinevoting.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VotingsDto {
    private Long voteId;
    private LocalDate voteDate;
    private Long candidate_id;
    private Long std_id;
}
