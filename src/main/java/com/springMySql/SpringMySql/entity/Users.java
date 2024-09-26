package com.springMySql.SpringMySql.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users_table")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private UserValidity userValidity;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Addresses> address=new ArrayList<>();
}
