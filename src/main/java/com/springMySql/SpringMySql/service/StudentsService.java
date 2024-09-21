package com.springMySql.SpringMySql.service;


import com.springMySql.SpringMySql.entity.StudentObj;
import com.springMySql.SpringMySql.respository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class StudentsService {
    @Autowired
    MyRepository myRepository;

    public List<StudentObj> getAllStudents(){
        return myRepository.findAll();
    }

    public void addStudent(@RequestBody StudentObj studentObj){
        myRepository.save(studentObj);
    }

    public void deleteStudent(Integer id){
        myRepository.deleteById(id);
    }

    public void updateStudent(@RequestBody StudentObj studentObj){
        myRepository.save(studentObj);
    }

    public Optional<StudentObj> getStudentById(Integer id){
        return myRepository.findById(id);
    }
}
