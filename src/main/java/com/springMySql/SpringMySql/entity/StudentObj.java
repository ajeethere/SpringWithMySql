package com.springMySql.SpringMySql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "STUDENTS")
public class StudentObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String gender;
}
