package com.sms.studentManagement.controller;

import com.sms.studentManagement.dto.LoginRequest;
import com.sms.studentManagement.models.Users;
import com.sms.studentManagement.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Users createUsers(@RequestBody Users user){

        return userService.createUsers(user);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequest request){
        System.out.println(request);
        return userService.verify(request);
    }

}
