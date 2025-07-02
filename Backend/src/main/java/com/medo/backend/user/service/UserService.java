package com.medo.backend.user.service;


import com.medo.backend.user.dto.UserProfileDTO;
import com.medo.backend.user.dto.UserUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface UserService {

    // for crude simple for the users
    UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO);
    boolean deleteUser(Long id);
    UserProfileDTO getUser(Long id);


}
