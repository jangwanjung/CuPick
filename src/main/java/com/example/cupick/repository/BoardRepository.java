package com.example.cupick.repository;

import com.example.cupick.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findByTitleContaining(String keyword);

}
