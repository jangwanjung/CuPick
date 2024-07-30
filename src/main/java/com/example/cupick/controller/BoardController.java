package com.example.cupick.controller;

import com.example.cupick.model.Board;
import com.example.cupick.repository.BoardRepository;
import com.example.cupick.repository.UserRepository;
import com.example.cupick.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class BoardController {

    private int countByCupidCount;
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;


    public void CountByCupidCount1 (int count) {
        this.countByCupidCount += count;
    };


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model,@PageableDefault(size = 3, sort = "score",direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("cumulativeCoupleCount", countByCupidCount);
        model.addAttribute("boardList",boardService.메인인기게시물(pageable));

        return "index";
    }

    @GetMapping("/board")
    public String mainBoard(Model model, @PageableDefault(size = 17, sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("boards",boardService.글목록(pageable));
        return "board/main";
    }

    @GetMapping("/board/write")
    public String boardwrite(){
        return "board/write";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable int id, Model model){
        Board board = boardRepository.findById(id).orElseThrow(()->{
            return new IllegalStateException("해당 게시물을 찾지못했습니다");
        });
        boardService.조회수증가(board);
        model.addAttribute("board",board);
        return "board/detail";
    }
    @GetMapping("/board/change/{id}")
    public String boardChange(@PathVariable int id, Model model){
        Board board = boardRepository.findById(id).orElseThrow(()->{
            return new IllegalStateException("해당 게시물을 찾지못했습니다");
        });
        model.addAttribute("board",board);
        return "board/change";
    }

    @GetMapping("/board/search")
    public String search(String keyword, Model model , @PageableDefault(size = 17, sort = "id",direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Board> searchList = boardService.검색(keyword,pageable);
        model.addAttribute("searchList", searchList);
        model.addAttribute("keyword",keyword);
        return "board/search";
    }
    @GetMapping("/board/best")
    public String bestBoard(Model model, @PageableDefault(size = 17, sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("boardList",boardService.베스트글목록(pageable));
        return "board/best";
    }


}
