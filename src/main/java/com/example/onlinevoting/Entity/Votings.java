package com.example.onlinevoting.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table
public class Votings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    private LocalDate voteDate;
    private long candidate_id;
//    @ManyToOne
//    @JoinColumn(name = "candidate_id")
//    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "std_id")
    private Student std;

}
