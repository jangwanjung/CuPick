package com.example.cupick.controller.api;

import com.example.cupick.dto.ResponseDto;
import com.example.cupick.model.User;
import com.example.cupick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
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
}
