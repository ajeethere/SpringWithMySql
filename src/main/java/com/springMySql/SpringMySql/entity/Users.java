package com.springMySql.SpringMySql.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Addresses address;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_add_id")
//    private List<Addresses> address=new ArrayList<>();
}
