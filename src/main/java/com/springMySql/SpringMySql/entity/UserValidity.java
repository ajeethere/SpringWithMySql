package com.springMySql.SpringMySql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_validity")
@Data
public class UserValidity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int isValid;

    @OneToOne
    @JsonIgnore
    private Users user;

    @JsonProperty("user_id")
    public Long getUserId() {
        return user!=null?user.getId():null;
    }
}
