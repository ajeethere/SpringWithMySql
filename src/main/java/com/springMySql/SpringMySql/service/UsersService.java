package com.springMySql.SpringMySql.service;


import com.springMySql.SpringMySql.entity.Users;
import com.springMySql.SpringMySql.respository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public void addUser(Users user) {
        usersRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

}
