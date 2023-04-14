package com.cpan252.distributioncentre.model.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.cpan252.distributioncentre.model.User;

import lombok.Data;


@Data
public class CreateUser {

    private String username;
    private String password;


    public User toUser(PasswordEncoder passwordEncoder){
        return User.builder()
            .username(username)
            .password(passwordEncoder.encode(password))
            .build();
    }


    public CreateUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
