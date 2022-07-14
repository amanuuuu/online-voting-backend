package com.example.onlinevoting.Controller;

import com.example.onlinevoting.Entity.User;
import com.example.onlinevoting.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Data
@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    @RequestMapping(path = "post",method = RequestMethod.POST )
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(path="get",method = RequestMethod.GET)
    public List<User> getUser(){
        return userService.getUsers();
    }

    @GetMapping("login/username/{username}/password/{password}")
    public User loginController(@PathVariable("username") String username,@PathVariable("password") String password){
        return userService.login(username,password);
    }
}
