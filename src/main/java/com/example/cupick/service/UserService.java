package com.example.cupick.service;

import com.example.cupick.model.User;
import com.example.cupick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}
