package com.example.cupick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String loginform() {
        return "user/login";
    }

    @GetMapping("/join")
    public String joinform() {
        return "user/join";
    }
    @GetMapping("/register")
    public String registrationform() {
        return "user/register";
    }
}
