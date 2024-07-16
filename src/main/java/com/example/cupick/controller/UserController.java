package com.example.cupick.controller;

import com.example.cupick.repository.UserRepository;
import com.example.cupick.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginform() {
        return "user/login";
    }

    @GetMapping("/join")
    public String joinform() {
        return "user/join";
    }

    @GetMapping("/register")
    public String registerform() {
        return "user/register";
    }

    @GetMapping("/user/update")
    public String userUpdateForm() {
        return "user/update";
    }

}
