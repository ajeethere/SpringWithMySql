package com.springMySql.SpringMySql.service;

import com.springMySql.SpringMySql.entity.UserValidity;
import com.springMySql.SpringMySql.respository.UserValidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserValidityService {
    @Autowired
    UserValidityRepository userValidityRepository;


    public void addUserValidity(UserValidity userValidity) {
        userValidityRepository.save(userValidity);
    }

    public List<UserValidity> getUserValidity(){
        return userValidityRepository.findAll();
    }

    public List<UserValidity> getUserValidityByValid(){
        return userValidityRepository.getUserValidityByIsValid(1);
    }

    public void updateUserValidity(UserValidity userValidity){
        userValidityRepository.save(userValidity);
    }
}
