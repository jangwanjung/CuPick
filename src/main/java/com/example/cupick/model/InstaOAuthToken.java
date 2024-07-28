package com.example.cupick.model;

import lombok.Data;

import java.util.List;

@Data
public class InstaOAuthToken {
    public String access_token;
    public Long user_id;
    public List<String> permissions;

}
