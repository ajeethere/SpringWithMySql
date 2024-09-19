package com.springMySql.SpringMySql.controller;

import com.springMySql.SpringMySql.entity.StudentObj;
import com.springMySql.SpringMySql.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentsService studentsService;

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentObj studentObj) {
        studentsService.addStudent(studentObj);
        return new ResponseEntity<>(studentObj,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<StudentObj> students = studentsService.getAllStudents();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
}
