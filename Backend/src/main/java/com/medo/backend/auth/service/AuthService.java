package com.medo.backend.auth.service;

import com.medo.backend.auth.dto.AuthResponse;
import com.medo.backend.auth.dto.CreateUserDTO;
import com.medo.backend.user.dto.UserProfileDTO;

public interface AuthService {
    public AuthResponse createAccount(CreateUserDTO userDTO);
    public AuthResponse login(String email, String password);

}
