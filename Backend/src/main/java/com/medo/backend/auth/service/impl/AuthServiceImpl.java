package com.medo.backend.auth.service.impl;

import com.medo.backend.auth.dto.AuthResponse;
import com.medo.backend.auth.dto.CreateUserDTO;
import com.medo.backend.auth.service.AuthService;
import com.medo.backend.user.dto.UserProfileDTO;

public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse createAccount(CreateUserDTO userDTO) {
        return null;
    }

    @Override
    public AuthResponse login(String email, String password) {
        return null;
    }
}
