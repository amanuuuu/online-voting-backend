package com.example.onlinevoting.Repository;

import com.example.onlinevoting.Entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends JpaRepository<Campus ,Long> {
}
