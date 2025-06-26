package com.medo.backend.user.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Badget {
    @Id
    private Long budgetId;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}
