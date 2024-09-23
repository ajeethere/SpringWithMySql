package com.springMySql.SpringMySql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "addresses")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addId;
    private String addressLine1;
    private String addressLine2;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Users user;
}
