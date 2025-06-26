package com.medo.backend.user.model;


import jakarta.persistence.*;

@Entity
public class Badget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long budgetId;
    private  String title;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}
