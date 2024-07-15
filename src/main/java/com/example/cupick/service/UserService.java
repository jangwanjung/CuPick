package com.example.cupick.service;

import com.example.cupick.model.User;
import com.example.cupick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public void 회원가입(User user){
        String nowpassword = user.getPassword();
        String encpassword = encoder.encode(nowpassword);
        user.setPassword(encpassword);
        userRepository.save(user);
    }
    @Transactional
    public void 등록(User user){
        User existuser = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원찾기 실패");
        });
        existuser.setLikeNumber(user.getLikeNumber());
        existuser.setLikeName(user.getLikeName());
    }

    @Transactional
    public void 초기화(User user){
        User existuser = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원찾기 실패");
        });
        existuser.setLikeNumber(null);
        existuser.setLikeName(null);
    }

    @Transactional
    public void 확인(int id,String likeNumber,String likeName){


        User registerUser = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("회원을 찾을수없습니다");
        });
        Optional<User> checkUser = userRepository.findByPhoneNumber(likeNumber);

        if (checkUser.isPresent()) {
            // 전화번호로 사용자를 찾은경우
            String name = checkUser.get().getUsername();
            if(name.equals(likeName)){
                String 확인당한사람이좋아하는사람의번호 = checkUser.get().getLikeNumber();
                String 확인당한사람이좋아하는사람의이름 = checkUser.get().getLikeName();
                if(registerUser.getUsername().equals(확인당한사람이좋아하는사람의이름)&&registerUser.getPhoneNumber().equals(확인당한사람이좋아하는사람의번호)){
                    checkUser.get().setCupid(true);
                    registerUser.setCupid(true);
                }
            }
        }
    };


}
