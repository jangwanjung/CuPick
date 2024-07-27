package com.example.cupick.controller;

import com.example.cupick.model.KakaoPhoneNumber;
import com.example.cupick.model.OAuthToken;
import com.example.cupick.repository.UserRepository;
import com.example.cupick.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {


    private final UserService userService;
    private final ObjectMapper jacksonObjectMapper;

    public UserController(UserService userService, ObjectMapper jacksonObjectMapper) {
        this.userService = userService;
        this.jacksonObjectMapper = jacksonObjectMapper;
    }

    @GetMapping("/login")
    public String loginform() {
        return "user/login";
    }

    @GetMapping("/join")
    public String joinform() {
        return "user/join";
    }

    @GetMapping("/register")
    public String registerform() {
        return "user/register";
    }

    @GetMapping("/user/update")
    public String userUpdateForm() {
        return "user/update";
    }

    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(String code){
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/x-www-form-urlencoded");
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("grant_type","authorization_code");
        param.add("client_id","8c149c8510c63f0fcaf317b76e597bc4");
        param.add("redirect_uri","http://localhost:8000/auth/kakao/callback");
        param.add("code",code);
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(param, headers);
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );
        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oauthToken = null;
        try {
            oauthToken = objectMapper.readValue(response.getBody(),OAuthToken.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(oauthToken.getAccess_token());

        RestTemplate rt2 = new RestTemplate();
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
        headers2.add("Authorization","Bearer "+oauthToken.getAccess_token());
        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest2 = new HttpEntity<>(headers2);
        ResponseEntity<String> respones2 = rt2.exchange(
                //post요청주소
                "https://kapi.kakao.com/v2/user/me",
                //http메소드
                HttpMethod.POST,
                //보낼값
                kakaoProfileRequest2,
                String.class
        );
        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoPhoneNumber kakaoPhoneNumber = null;
        try {
            kakaoPhoneNumber = objectMapper2.readValue(respones2.getBody(), KakaoPhoneNumber.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        userService.전화번호등록(kakaoPhoneNumber.getKakao_account().getPhone_number());

        return "redirect:/register";
    }

}
