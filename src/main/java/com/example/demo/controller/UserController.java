package com.example.demo.controller;

import com.example.demo.DTO.ApiResponse;
import com.example.demo.DTO.LoginRequestDto;
import com.example.demo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserLoginService userLoginService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequestDto loginRequestDto){
        String token = userLoginService.generateToken(loginRequestDto.getEmail());
        return ResponseEntity.ok(new ApiResponse(true,"Success",token));
    }
}
