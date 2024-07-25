package com.example.cupick.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @JoinColumn(name = "boardId")
    @ManyToOne
    private Board board;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    @CreationTimestamp
    private Timestamp creatData;
}
