package com.medo.backend.auth.dto;

import com.medo.backend.user.model.Competence;

import java.util.List;

public class CreateUserDTO {
    private String name;
    private String email;
    private String password;
    private String bio;
    private String avatarUrl;
    private List<Competence> competences;
}
