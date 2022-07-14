package com.example.onlinevoting.Repository;

import com.example.onlinevoting.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM `user` WHERE username=? and password=?",nativeQuery = true)
    public User loginRepository(String username,String password);
}
