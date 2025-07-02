package com.medo.backend.user.controller;


import com.medo.backend.user.dto.UserProfileDTO;
import com.medo.backend.user.dto.UserUpdateDTO;
import com.medo.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController  {

     private final UserService userService;

     @Autowired
     public UserController(UserService userService) {
         this.userService = userService;
     }

    @PostMapping("/updateProfile/{id}")
    public UserUpdateDTO updateUser(@RequestBody  UserUpdateDTO userUpdateDTO ,@PathVariable Long id) {
        return new UserUpdateDTO(2L,"test","hfh",null , null , null, null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable  Long id) {
         boolean result = userService.deleteUser(id);
         if (result) {
             return ResponseEntity.ok().build();
         }
         else {
            return ResponseEntity.notFound().build();
         }
    }

    @GetMapping("/display/{id}")
    public UserProfileDTO getUser(@PathVariable  Long id) {
         return userService.getUser(id);

    }
}
