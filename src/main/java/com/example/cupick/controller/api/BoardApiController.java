package com.example.cupick.controller.api;

import com.example.cupick.config.auth.PrincipalDetail;
import com.example.cupick.dto.ResponseDto;
import com.example.cupick.model.Board;
import com.example.cupick.model.Reply;
import com.example.cupick.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;


    @PostMapping("/board/write")
    public ResponseDto<Integer> boardSave(@RequestBody Board board , @AuthenticationPrincipal PrincipalDetail principal){
        boardService.글쓰기(board,principal.getUser());

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PostMapping("/board/{boardId}/reply/write")
    public ResponseDto<Integer> replySave(@PathVariable int boardId, @RequestBody Reply reply , @AuthenticationPrincipal PrincipalDetail principal){
        System.out.println(111111);
        boardService.댓글쓰기(boardId,reply,principal.getUser());

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
    @DeleteMapping("/board/{boardId}/reply/delete/{replyId}")
    public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
        boardService.댓글삭제(replyId);

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @DeleteMapping("/board/delete/{boardId}")
    public ResponseDto<Integer> boardDelete(@PathVariable int boardId){
        boardService.글삭제(boardId);

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PutMapping("/board/change/{boardId}")
    public ResponseDto<Integer> boardChange(@PathVariable int boardId,@RequestBody Board board){
        boardService.글수정(boardId,board);

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}
