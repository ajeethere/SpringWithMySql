package com.springMySql.SpringMySql.controller;

import com.springMySql.SpringMySql.entity.StudentObj;
import com.springMySql.SpringMySql.errors.ErrorResponse;
import com.springMySql.SpringMySql.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentsService studentsService;

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentObj studentObj) {
        studentsService.addStudent(studentObj);
        return new ResponseEntity<>(studentObj, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<StudentObj> students = studentsService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        Optional<StudentObj> old = studentsService.getStudentById(id);
        if (old.isPresent()) {
            studentsService.deleteStudent(id);
            return new ResponseEntity<>("Student deleted successfully!",HttpStatus.OK);
        } else {
            ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND,"Student not found!");
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
        Optional<StudentObj> studentObj = studentsService.getStudentById(id);
        return new ResponseEntity<>(studentObj, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable Integer id, @RequestBody StudentObj studentObj) {
        Optional<StudentObj> old = studentsService.getStudentById(id);
        if (old.isPresent()) {
            if (!studentObj.getName().isEmpty()) {
                old.get().setName(studentObj.getName());
            } else {
                old.get().setName(old.get().getName());
            }
            if (!studentObj.getGender().isEmpty()) {
                old.get().setGender(studentObj.getGender());
            } else {
                old.get().setGender(old.get().getGender());
            }
            if (studentObj.getAge() != 0) {
                old.get().setAge(studentObj.getAge());
            } else {
                old.get().setAge(old.get().getAge());
            }
            studentsService.updateStudent(old.get());
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
}
