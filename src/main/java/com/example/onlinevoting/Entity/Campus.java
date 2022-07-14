package com.example.onlinevoting.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campusId;
    private String campusName;

     @OneToMany
    @JoinColumn(name="campus_id")
    private List<Course> courseList;
}
