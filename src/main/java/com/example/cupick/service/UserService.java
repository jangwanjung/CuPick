package com.example.cupick.service;

import com.example.cupick.model.User;
import com.example.cupick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
