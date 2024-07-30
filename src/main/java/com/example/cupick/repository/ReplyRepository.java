package com.example.cupick.repository;

import com.example.cupick.model.Board;
import com.example.cupick.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    Optional<Integer> findByboardId(int replyId);

}
