package com.example.cupick.model;

import lombok.Builder;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String instaId;

    private String nickname;

    private String password;

    private String email;

    private String phoneNumber;

    private String likeId;

    private String likeNumber;

    @CreationTimestamp
    private Timestamp creatDate;

    private boolean cupid = false;



}
