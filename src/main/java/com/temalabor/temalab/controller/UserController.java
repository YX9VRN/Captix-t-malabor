package com.temalabor.temalab.controller;

import com.temalabor.temalab.UserDetailServiceImpl;
import com.temalabor.temalab.model.AuthenticationRequest;
import com.temalabor.temalab.model.AuthenticationResponse;
import com.temalabor.temalab.model.User;
import com.temalabor.temalab.repository.UserRepository;
import com.temalabor.temalab.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users/{_id}")
    public Optional<User> getUserById(@PathVariable("_id") String _id){
        return userRepository.findById(_id);
    }

    @GetMapping(value = "/users")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @CrossOrigin
    @PostMapping(value = "/users")
    public User newUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
