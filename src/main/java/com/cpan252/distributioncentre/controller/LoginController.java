package com.cpan252.distributioncentre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping()
public class LoginController {
    @PostMapping("/login")
public String processLogin(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
    // Perform authentication logic here
    
    // Set the session cookie
    Cookie cookie = new Cookie("SESSIONID", "xxxxxxx");
    cookie.setMaxAge(60 * 60); // 1 hour expiration
    response.addCookie(cookie);
    
    return "redirect:http://localhost:8080/Centres"; // Redirects the user to the dashboard page
}
}
