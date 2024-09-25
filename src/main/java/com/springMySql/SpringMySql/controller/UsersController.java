package com.springMySql.SpringMySql.controller;

import com.springMySql.SpringMySql.entity.Users;
import com.springMySql.SpringMySql.errors.ErrorResponse;
import com.springMySql.SpringMySql.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @PostMapping
    public ResponseEntity<?> addUsers(@RequestBody Users users) {
        usersService.addUser(users);
        return ResponseEntity.ok("User added successfully");
    }
    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok("User Deleted successfully");
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        Users user=usersService.loginValidation(username, password);
        if (user!=null) {
            if (user.getPassword().equals(password)) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST,"Incorrect Password!"),HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND,"Incorrect Email and Password!"),HttpStatus.NOT_FOUND);
        }
    }
}
