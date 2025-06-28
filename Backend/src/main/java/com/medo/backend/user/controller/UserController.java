package com.medo.backend.user.controller;


import com.medo.backend.user.dto.UserProfileDTO;
import com.medo.backend.user.dto.UserUpdateDTO;
import com.medo.backend.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/")
public class UserController  {

    @PostMapping("updateProfile")
    public UserUpdateDTO updateUser(@RequestBody  UserUpdateDTO userUpdateDTO) {
        return new UserUpdateDTO(2L,"test","hfh",null , null , null, null);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable  Long id) {

        System.out.println(id);

    }

    @GetMapping("display/{id}")
    public UserProfileDTO getUser(@PathVariable  Long id) {
        return new UserProfileDTO(2L,"test","hfh",null , null , null, 1, null, null);
    }
}
