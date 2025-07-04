package com.medo.backend.user.model;


import jakarta.persistence.*;
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
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String bio;
    private String avatarUrl;
    @OneToMany(mappedBy = "user")
    private List<Competence> competences;
    private int reputation;
    @OneToMany(mappedBy = "user")
    private  List<Badget> badgets;
    private String niveau;

}
