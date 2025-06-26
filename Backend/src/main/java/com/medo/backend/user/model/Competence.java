package com.medo.backend.user.model;


import jakarta.persistence.*;

@Entity
@
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long competenceId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user")
    private  User user;

}
