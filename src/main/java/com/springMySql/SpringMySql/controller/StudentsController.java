package com.springMySql.SpringMySql.controller;


import com.springMySql.SpringMySql.entity.MyTable;
import com.springMySql.SpringMySql.respository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {
    @Autowired
    MyRepository myRepository;

    public List<MyTable> getAllStudents(){
        return myRepository.findAll();
    }

    public MyTable addStudent(@RequestBody MyTable myTable){
        return myRepository.save(myTable);
    }
}
