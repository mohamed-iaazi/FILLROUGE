package com.medo.backend.user.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String bio;
    private String avatarUrl;
    private List<String> competences;
    private List<Role> roles;
    private int reputation;
    private  List<Badget> badgets;
    private String niveau;


}
