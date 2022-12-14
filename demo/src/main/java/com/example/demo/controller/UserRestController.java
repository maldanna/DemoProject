package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFounException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;



@RestController("/demo")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("/login/{Id}")
    public Boolean loginUser(@PathVariable("Id") String userName){
        return userService.loginUser(userName);
    }

    @GetMapping("/getuser/{Id}")
    public Optional<User> getUserById(@PathVariable("Id") String userId) throws UserNotFounException{
        return userService.getUser(userId);
    }


    @GetMapping("/getAllUsers")
    public List<User>  getAllUsers(){
        return userService.getAllUsers();

    }

    @PostMapping("/signup")
    public String addUser(@RequestBody @Valid User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/delete/{username}")
    public String deleteMethod(@PathVariable("username") String  userName){   
        return userService.deleteUser(userName);
    }  

}
