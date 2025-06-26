package com.medo.backend.user.model;


import jakarta.persistence.*;

@Entity
public class Competences {
    @Id
    private Long competenceId;


    @ManyToOne
    @JoinColumn(name = "user")
    private  User user;

}
