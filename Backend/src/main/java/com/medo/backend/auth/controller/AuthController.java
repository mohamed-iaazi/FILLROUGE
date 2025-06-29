package com.medo.backend.auth.controller;


import com.medo.backend.auth.dto.AuthRequest;
import com.medo.backend.auth.dto.AuthResponse;
import com.medo.backend.auth.dto.CreateUserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @PostMapping("/login")
    public AuthResponse auth(@RequestBody AuthRequest authRequest) {
        return new AuthResponse();
    }


    @PostMapping("/register")
    public AuthResponse createAccount(@RequestBody  CreateUserDTO createUserDTO) {
        return new AuthResponse();
    }

}
