package com.medo.backend.user.dto;

import com.medo.backend.user.model.Badget;
import com.medo.backend.user.model.Competence;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class UserProfileDTO {
    private Long userId;
    private String name;
    private String email;
    private String bio;
    private String avatarUrl;
    private List<Competence> competences;
    private int reputation;
    private  List<Badget> badgets;
    private String niveau;
}
