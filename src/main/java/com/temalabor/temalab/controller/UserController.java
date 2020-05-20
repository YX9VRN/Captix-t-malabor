package com.temalabor.temalab.controller;

import com.temalabor.temalab.UserDetailServiceImpl;
import com.temalabor.temalab.model.AuthenticationRequest;
import com.temalabor.temalab.model.AuthenticationResponse;
import com.temalabor.temalab.model.User;
import com.temalabor.temalab.repository.UserRepository;
import com.temalabor.temalab.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{_id}")
    public Optional<User> getUserById(@PathVariable("_id") String _id){
        return userRepository.findById(_id);
    }

    @GetMapping()
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    
    @PostMapping()
    public String newUser(@RequestBody User user){
        if (userRepository.findByUsername(user.getUsername()) != null){
            return "Wrong username";
        }
        userRepository.save(user);
        return "User saved";
    }
}
