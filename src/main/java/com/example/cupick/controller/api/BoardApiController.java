package com.example.cupick.controller.api;

import com.example.cupick.config.auth.PrincipalDetail;
import com.example.cupick.dto.ResponseDto;
import com.example.cupick.model.Board;
import com.example.cupick.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/board/write")
    public ResponseDto<Integer> boardSave(@RequestBody Board board , @AuthenticationPrincipal PrincipalDetail principal){
        boardService.글쓰기(board,principal.getUser());

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}
