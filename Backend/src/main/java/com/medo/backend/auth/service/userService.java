package com.medo.backend.auth.service;

import com.medo.backend.auth.dto.CreateUserDTO;
import com.medo.backend.user.dto.UserProfileDTO;

public interface userService {
    public UserProfileDTO createAccount(CreateUserDTO userDTO);
    public UserProfileDTO login();

}
