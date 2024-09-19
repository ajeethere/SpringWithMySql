package com.springMySql.SpringMySql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "STUDENTS")
public class MyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
}
