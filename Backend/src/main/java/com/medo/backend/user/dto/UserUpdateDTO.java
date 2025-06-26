package com.medo.backend.user.dto;

import com.medo.backend.user.model.Badget;
import com.medo.backend.user.model.Competence;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserUpdateDTO {
    private String name;
    private String email;
    private String password;
    private String bio;
    private String avatarUrl;
    private List<Competence> competences;
}
