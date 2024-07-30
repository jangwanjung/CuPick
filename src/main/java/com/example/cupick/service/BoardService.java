package com.example.cupick.service;

import com.example.cupick.model.Board;
import com.example.cupick.model.Reply;
import com.example.cupick.model.User;
import com.example.cupick.repository.BoardRepository;
import com.example.cupick.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;


    @Transactional
    public Page<Board> 글목록(Pageable pageable){
        return boardRepository.findAll(pageable);
    }


    @Transactional
    public void 글쓰기(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);

    }

    @Transactional
    public void 댓글쓰기(int boardId, Reply reply, User user){
        Board board = boardRepository.findById(boardId).orElseThrow(()->{
            return new IllegalArgumentException("게시물을 찾을수 없습니다");
        });
        reply.setBoard(board);
        reply.setUser(user);
        board.setScore(board.getScore() + 4);
        replyRepository.save(reply);

    }
    @Transactional
    public void 댓글삭제(int replyId){
         /*int boardid = replyRepository.findByboardId(replyId).orElseThrow(()->{
            return new IllegalArgumentException("해당댓글을 찾을수 없습니다");
        });
        Board board = boardRepository.findById(boardid).orElseThrow(()->{
            return new IllegalArgumentException("게시글의 점수부여를 실패하였습니다");
        });
        board.setScore(board.getScore() - 4);*/
        replyRepository.deleteById(replyId);

    }

    @Transactional
    public void 글삭제(int boardId){
        boardRepository.deleteById(boardId);
    }

    @Transactional
    public void 글수정(int boardId, Board requestBoard){
        Board board = boardRepository.findById(boardId).orElseThrow(()->{
            return new IllegalArgumentException("글찾기 실패");
        });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
    }

    @Transactional
    public void 조회수증가(Board board){
        board.setCount(board.getCount()+1);
        board.setScore(board.getScore()+1);
    }

    @Transactional
    public Page<Board> 검색(String keyword,Pageable pageable){
        Page<Board> boardList = boardRepository.findByTitleContaining(keyword,pageable);
        return boardList;
    }

    @Transactional
    public Page<Board> 메인인기게시물(Pageable pageable){
        Page<Board> boardList = boardRepository.findAll(pageable);
        return boardList;
    }

    @Transactional
    public Page<Board> 베스트글목록(Pageable pageable){
        Page<Board> boardList = boardRepository.findByScoreGreaterThan(10,pageable);
        return boardList;
    }

}
