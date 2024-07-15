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

    @Transactional
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
        existuser.setLikeId(user.getLikeId());
    }

    @Transactional
    public void 초기화(User user){
        User existuser = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원찾기 실패");
        });
        existuser.setLikeNumber(null);
        existuser.setLikeId(null);
    }

    @Transactional
    public void 확인(int id,String likeNumber,String likeId){

        System.out.println(1111111111);
        User registerUser = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("회원을 찾을수없습니다"); //내 User객체가져오자
        });
        System.out.println(22222222);
        if(!likeNumber.equals("")) {
            Optional<User> checkUser1 = userRepository.findByPhoneNumber(likeNumber);
            if (checkUser1.isPresent()) {
                String 인스타아이디 = checkUser1.get().getLikeId();   //그사람이 좋아하는사람의 인스타아이디를가져오자
                String number = checkUser1.get().getLikeNumber();  //그사람이 좋아하는사람의 전화번호를 가져오자
                System.out.println(33333333);
                if ( (인스타아이디!=null&&인스타아이디.equals(registerUser.getInstaId())) || (number!=null&&number.equals(registerUser.getPhoneNumber()))) { //하나라도 동일할때
                    System.out.println(44444444);
                    checkUser1.get().setCupid(true);
                    registerUser.setCupid(true);

                }
            }
        }
        else{
            if(!likeId.equals("")){
                Optional<User> checkUser2 = userRepository.findByInstaId(likeId);
                System.out.println(55555555);
                if (checkUser2.isPresent()){
                    String 인스타아이디 = checkUser2.get().getLikeId();   //그사람이 좋아하는사람의 인스타아이디를가져오자
                    String number = checkUser2.get().getLikeNumber();  //그사람이 좋아하는사람의 전화번호를 가져오자
                    System.out.println(6666666);
                    if((인스타아이디!=null&&인스타아이디.equals(registerUser.getInstaId())) || (number!=null&&number.equals(registerUser.getPhoneNumber()))){ //하나라도 동일할때
                        checkUser2.get().setCupid(true);
                        registerUser.setCupid(true);
                    }
                }
            }
        }
    }
};

