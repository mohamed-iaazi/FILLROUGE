package com.medo.backend.user.service;


import com.medo.backend.user.dto.UserProfileDTO;
import com.medo.backend.user.dto.UserUpdateDTO;
import com.medo.backend.user.model.User;



public interface UserService {

    // for crude simple for the users
    boolean addNewUser(User user);
    boolean updateUser(UserUpdateDTO user);
    void deleteUser(User user);
    UserProfileDTO getUser(Long id);



}
