package com.example.onlinevoting.Repository;

import com.example.onlinevoting.Entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty ,Long> {
}
