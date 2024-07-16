package com.example.cupick.controller.api;

import com.example.cupick.config.auth.PrincipalDetail;
import com.example.cupick.dto.ResponseDto;
import com.example.cupick.model.User;
import com.example.cupick.repository.UserRepository;
import com.example.cupick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PutMapping("/reset")
    public ResponseDto<Integer> reset(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail ){
        userService.해제(user);
        userService.초기화(user);
        principalDetail.setUser(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PutMapping("/register")
    public ResponseDto<Integer> register(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail ){
        userService.해제(user);
        userService.등록(user);
        userService.확인(user.getId(),user.getLikeNumber(),user.getLikeId());
        User setUser = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException();
        });
        principalDetail.setUser(setUser);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}
