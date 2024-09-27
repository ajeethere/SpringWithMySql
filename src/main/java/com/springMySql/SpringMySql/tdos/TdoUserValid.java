package com.springMySql.SpringMySql.tdos;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TdoUserValid {
    private String username;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int isValid;
    private Long userId;
}
