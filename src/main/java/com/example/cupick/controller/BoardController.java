package com.example.cupick.controller;

import com.example.cupick.model.Board;
import com.example.cupick.repository.BoardRepository;
import com.example.cupick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class BoardController {

    private long countByCupidCount;
    @Autowired
    private BoardRepository boardRepository;


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
    public String mainBoard(Model model){
        model.addAttribute("boards",boardRepository.findAll());
        return "board/main";
    }

    @GetMapping("/board/write")
    public String boardwrite(){
        return "board/write";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable long id, Model model){
        Board board = boardRepository.findById(id).orElseThrow(()->{
            return new IllegalStateException("해당 게시물을 찾지못했습니다");
        });
        model.addAttribute("board",board);
        return "board/detail";
    }


}
