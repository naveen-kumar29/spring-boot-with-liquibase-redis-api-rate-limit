package com.example.liquibase.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;


@Setter
@Getter
@Table(name = "users")
@Entity
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    public User() {
    }

    public User(Long id, String email, String username, String password, Date createdAt) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "created_at")
    private Date createdAt;


}
