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

    @JoinColumn(name = "userId")
    @ManyToOne
    private Board board;

    @CreationTimestamp
    private Timestamp creatData;
}
