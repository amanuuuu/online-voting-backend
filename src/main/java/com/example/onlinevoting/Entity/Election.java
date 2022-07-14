package com.example.onlinevoting.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long election_id;
    private String election_type;
    private LocalDate election_date;
     @OneToMany
    @JoinColumn(name = "election_id")
    List<Candidate> candidates;

}
