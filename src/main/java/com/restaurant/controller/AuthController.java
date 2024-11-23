package com.restaurant.controller;

import com.restaurant.domain.dtos.LoginRequestDTO;
import com.restaurant.domain.dtos.LoginResponseDTO;
import com.restaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Validated
    @PostMapping(path = "/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {

        return userService.validateUser(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
    }
}
