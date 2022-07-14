package com.example.onlinevoting.Service;

import com.example.onlinevoting.Entity.User;
import com.example.onlinevoting.Repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User login(String username,String password){
        return userRepository.loginRepository(username,password);
    }
}
