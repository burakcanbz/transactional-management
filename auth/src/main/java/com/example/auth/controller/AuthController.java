package com.example.auth.controller;

import com.example.auth.dto.LoginUserDTO;
import com.example.auth.dto.RegisterUserDTO;
import com.example.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String Login(LoginUserDTO loginUserDTO) {
        return "login";
    }

    @PostMapping("/register")
    public String Register(RegisterUserDTO registerUserDTO) {
        return "register";
    }

    @PostMapping("/reset")
    public String ResetPassword(String password) {
        return "resetPassword";
    }

    @PostMapping("/logout")
    public String logout() {
        return "logout";
    }

}
