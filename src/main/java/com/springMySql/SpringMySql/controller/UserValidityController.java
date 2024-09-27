package com.springMySql.SpringMySql.controller;

import com.springMySql.SpringMySql.entity.UserValidity;
import com.springMySql.SpringMySql.entity.Users;
import com.springMySql.SpringMySql.service.UserValidityService;
import com.springMySql.SpringMySql.service.UsersService;
import com.springMySql.SpringMySql.tdos.TdoUserValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user-validity")
public class UserValidityController {

    @Autowired
    UserValidityService userValidityService;
    @Autowired
    UsersService usersService;


    @PostMapping
    public ResponseEntity<?> addUserValidity(@RequestBody TdoUserValid tdoUserValid) {
        Optional<Users> user=usersService.getUserById(tdoUserValid.getUserId());
        if (user.isPresent()) {
            UserValidity userValidity=new UserValidity();
            userValidity.setIsValid(tdoUserValid.getIsValid());
            userValidity.setUser(user.get());
            userValidity.setUsername(user.get().getUsername());
            userValidity.setStartTime(tdoUserValid.getStartTime());
            userValidity.setEndTime(tdoUserValid.getEndTime());

            userValidityService.addUserValidity(userValidity);
            return ResponseEntity.ok("User Validity added successfully");
        }else{
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public ResponseEntity<?> getUserValidity() {
        return ResponseEntity.ok(userValidityService.getUserValidity());
    }

}
