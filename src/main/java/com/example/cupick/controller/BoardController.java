package com.example.cupick.controller;

import com.example.cupick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class BoardController {

    private long countByCupidCount;


    public void CountByCupidCount1 (int count) {
        this.countByCupidCount += count;
    };

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cumulativeCoupleCount", countByCupidCount);
        return "index";
    }

    @GetMapping("/board")
    public String mainBoard(){
        return "board/main";
    }


}
