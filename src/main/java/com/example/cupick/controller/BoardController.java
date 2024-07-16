package com.example.cupick.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BoardController {

    @GetMapping("/")
    public String index() {
        return "index";
    }


}
