package com.example.onlinevoting.Repository;

import com.example.onlinevoting.Entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position , Long> {
}
