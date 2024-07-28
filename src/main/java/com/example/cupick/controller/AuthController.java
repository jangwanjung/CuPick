package com.example.cupick.controller;

import com.example.cupick.model.InstaOAuthToken;
import com.example.cupick.model.InstaUserName;
import com.example.cupick.model.KakaoPhoneNumber;
import com.example.cupick.model.KakaoOAuthToken;
import com.example.cupick.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(String code){
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/x-www-form-urlencoded");
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("grant_type","authorization_code");
        param.add("client_id","8c149c8510c63f0fcaf317b76e597bc4");
        param.add("redirect_uri","https://localhost:8443/auth/kakao/callback");
        param.add("code",code);
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(param, headers);
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );
        ObjectMapper objectMapper = new ObjectMapper();
        KakaoOAuthToken oauthTokenKakao = null;
        try {
            oauthTokenKakao = objectMapper.readValue(response.getBody(), KakaoOAuthToken.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(oauthTokenKakao.getAccess_token());

        RestTemplate rt2 = new RestTemplate();
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
        headers2.add("Authorization","Bearer "+ oauthTokenKakao.getAccess_token());
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

    @Value("${insta_secret}")
    private String insta_secret;

    @GetMapping("/auth/insta/callback")
    public String instaCallback(String code){
        RestTemplate rt = new RestTemplate();
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("client_id","7677997738994727");
        param.add("client_secret",insta_secret);
        param.add("grant_type","authorization_code");
        param.add("redirect_uri","https://localhost:8443/auth/insta/callback");
        param.add("code",code);

        HttpEntity<MultiValueMap<String, String>> instaTokenRequest = new HttpEntity<>(param,null);

        ResponseEntity<String> response = rt.exchange(
                "https://api.instagram.com/oauth/access_token",
                HttpMethod.POST,
                instaTokenRequest,
                String.class
        );
        ObjectMapper objectMapper = new ObjectMapper();
        InstaOAuthToken oauthTokenInsta = null;
        try {
            oauthTokenInsta = objectMapper.readValue(response.getBody(), InstaOAuthToken.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String accessToken = oauthTokenInsta.getAccess_token();
        long userId = oauthTokenInsta.getUser_id();

        String userInfoUrl = "https://graph.instagram.com/"+userId+"?fields=id,username&access_token="+accessToken;
        ResponseEntity<String> response2 = rt.exchange(
                userInfoUrl,
                HttpMethod.GET,
                null,
                String.class
        );

        ObjectMapper objectMapper2 = new ObjectMapper();
        InstaUserName instaUserName = null;
        try {
            instaUserName = objectMapper2.readValue(response2.getBody(), InstaUserName.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        userService.인스타아이디등록(instaUserName.getUsername());

        return "redirect:/register";
    }


}
