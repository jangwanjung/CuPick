package com.example.cupick.controller;

import com.example.cupick.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

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
