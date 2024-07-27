package com.example.cupick.model;


import lombok.Data;

@Data
public class KakaoPhoneNumber {

    public Long id;
    public String connected_at;
    public Kakao_account kakao_account;

    @Data
    public class Kakao_account {

        public Boolean has_phone_number;
        public Boolean phone_number_needs_agreement;
        public String phone_number;

    }

}