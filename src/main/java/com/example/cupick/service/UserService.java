package com.example.cupick.service;

import com.example.cupick.config.auth.PrincipalDetail;
import com.example.cupick.config.auth.PrincipalDetailService;
import com.example.cupick.controller.BoardController;
import com.example.cupick.model.User;
import com.example.cupick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private BoardController boardController;
    @Autowired
    private PrincipalDetailService principalDetailService;

    private String getEmail(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        Object principal = loggedInUser.getPrincipal();
        return principal.getClass().getSimpleName();
    }

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
    public void 전화번호등록(String phoneNumber){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetail user1 = (PrincipalDetail) authentication.getPrincipal();
        User user = userRepository.findById(user1.getUser().getId()).orElseThrow(()->{
            return new IllegalArgumentException("로그인이 되어있지않음");
        });
        if (phoneNumber.startsWith("+82")) {
            phoneNumber = phoneNumber.substring(3).trim();
        }

        // Step 2: Remove spaces and hyphens
        phoneNumber = phoneNumber.replaceAll("[\\s-]", "");

        // Step 3: Add leading zero if necessary
        if (!phoneNumber.startsWith("0")) {
            phoneNumber = "0" + phoneNumber;
        }

        user.setPhoneNumber(phoneNumber);

        PrincipalDetail updatedPrincipalDetail = new PrincipalDetail(user);

        // 새로운 Authentication 객체 생성
        Authentication newAuth = new UsernamePasswordAuthenticationToken(
                updatedPrincipalDetail,
                authentication.getCredentials(),
                authentication.getAuthorities()
        );

        // SecurityContextHolder에 새로운 Authentication 객체 설정
        SecurityContextHolder.getContext().setAuthentication(newAuth);




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
    public void 해제(User 유저){
        User user = userRepository.findById(유저.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원을 찾을수 없습니다");
        });
        if(user.getLikeNumber() != null && !user.getLikeNumber().equals("")){
            Optional<User> 좋아했던유저 = userRepository.findByPhoneNumber(user.getLikeNumber());
            if(좋아했던유저.isPresent()&&
                    ((좋아했던유저.get().getLikeNumber()!=null&&좋아했던유저.get().getLikeNumber().equals(user.getPhoneNumber()))
                            ||(좋아했던유저.get().getLikeId()!=null&&좋아했던유저.get().getLikeId().equals(user.getInstaId())))){ //찾으면
                좋아했던유저.get().setCupid(false);
                user.setCupid(false);
                return;
            }
        }

        if(user.getLikeId() != null && !user.getLikeId().equals("")){

            Optional<User> 좋아했던유저 = userRepository.findByInstaId(user.getLikeId());
            if(좋아했던유저.isPresent()&&
                    ((좋아했던유저.get().getLikeNumber()!=null&&좋아했던유저.get().getLikeNumber().equals(user.getPhoneNumber()))
                            ||(좋아했던유저.get().getLikeId()!=null&&좋아했던유저.get().getLikeId().equals(user.getInstaId())))){ //찾으면
                좋아했던유저.get().setCupid(false);
                user.setCupid(false);
            }
        }

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
            System.out.println(7777777);
            if (checkUser1.isPresent()) {
                String 인스타아이디 = checkUser1.get().getLikeId();   //그사람이 좋아하는사람의 인스타아이디를가져오자
                String number = checkUser1.get().getLikeNumber();  //그사람이 좋아하는사람의 전화번호를 가져오자
                System.out.println(33333333);
                if ( (인스타아이디!=null&&인스타아이디.equals(registerUser.getInstaId())) || (number!=null&&number.equals(registerUser.getPhoneNumber()))) { //하나라도 동일할때
                    System.out.println(44444444);
                    checkUser1.get().setCupid(true);
                    registerUser.setCupid(true);
                    boardController.CountByCupidCount1(2);
                    return;
                }
            }
        }

        if(!likeId.equals("")){
            Optional<User> checkUser2 = userRepository.findByInstaId(likeId);
            System.out.println(55555555);
            if (checkUser2.isPresent()){
                System.out.println(88888888);
                String 인스타아이디 = checkUser2.get().getLikeId();   //그사람이 좋아하는사람의 인스타아이디를가져오자
                String number = checkUser2.get().getLikeNumber();  //그사람이 좋아하는사람의 전화번호를 가져오자
                System.out.println(6666666);
                if((인스타아이디!=null&&인스타아이디.equals(registerUser.getInstaId())) || (number!=null&&number.equals(registerUser.getPhoneNumber()))){ //하나라도 동일할때
                    checkUser2.get().setCupid(true);
                    registerUser.setCupid(true);
                    boardController.CountByCupidCount1(2);
                }
            }
        }

    }
};

