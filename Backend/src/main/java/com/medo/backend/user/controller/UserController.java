package com.medo.backend.user.controller;


import com.medo.backend.auth.dto.CreateUserDTO;
import com.medo.backend.user.dto.UserProfileDTO;
import com.medo.backend.user.dto.UserUpdateDTO;
import com.medo.backend.user.model.User;
import com.medo.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController  {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserProfileDTO createUser(@RequestBody CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO);
    }

    @PostMapping("/updateProfile/{id}")
    public UserProfileDTO updateUser(@RequestBody  UserUpdateDTO userUpdateDTO ,@PathVariable Long id) {
        return userService.updateUser(userUpdateDTO).userToDto(
            userService.getUser(id).toUserProfileDTO(
                userService.getUser(id)
            )
        );
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable  Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/display/{id}")
    public UserProfileDTO getUser(@PathVariable  Long id) {
        return userService.getUser(id);
    }
}
