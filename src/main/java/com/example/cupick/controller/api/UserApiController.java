package com.example.cupick.controller.api;

import com.example.cupick.config.auth.PrincipalDetail;
import com.example.cupick.dto.ResponseDto;
import com.example.cupick.model.User;
import com.example.cupick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PutMapping("/register")
    public ResponseDto<Integer> register(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail ){
        userService.등록(user);
        principalDetail.setUser(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PutMapping("/reset")
    public ResponseDto<Integer> reset(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail ){
        userService.초기화(user);
        principalDetail.setUser(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}
