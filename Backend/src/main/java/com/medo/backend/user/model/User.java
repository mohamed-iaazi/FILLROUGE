package com.medo.backend.user.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String bio;
    private String avatarUrl;
    private List<Competences> competences;
    private int reputation;
    private  List<Badget> badgets;
    private String niveau;

}
