package com.cpan252.distributioncentre.controller;

import java.io.IOException;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.cpan252.distributioncentre.model.dto.CreateUser;
import com.cpan252.distributioncentre.repository.UserRepository;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    // @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    // public ResponseEntity<String> registerUserAccount(@RequestParam("username") String username, @RequestParam("password") String password){
    //     CreateUser user = new CreateUser(username, password);
    //     userRepository.save(user.toUser(passwordEncoder));
    //     return ResponseEntity.ok("User registered successfully.");
    // }

    @PostMapping("/register")
    public RedirectView registerUserAccount(@ModelAttribute CreateUser user) {
        userRepository.save(user.toUser(passwordEncoder));
        return new RedirectView("http://localhost:8080/login");
    }

    
}
