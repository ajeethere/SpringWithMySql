package com.springMySql.SpringMySql.controller;

import com.springMySql.SpringMySql.entity.UserValidity;
import com.springMySql.SpringMySql.service.UserValidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user-validity")
public class UserValidityController {

    @Autowired
    UserValidityService userValidityService;

    @PostMapping
    public ResponseEntity<?> addUserValidity(@RequestBody UserValidity userValidity) {
        userValidityService.addUserValidity(userValidity);
        return ResponseEntity.ok("User Validity added successfully");
    }

    @GetMapping
    public LocalDateTime getUserValidity() {
        return LocalDateTime.now();
//        return ResponseEntity.ok(userValidityService.getUserValidity());
    }

}
