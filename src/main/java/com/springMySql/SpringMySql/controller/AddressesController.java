package com.springMySql.SpringMySql.controller;

import com.springMySql.SpringMySql.entity.Addresses;
import com.springMySql.SpringMySql.errors.ErrorResponse;
import com.springMySql.SpringMySql.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressesController {

    @Autowired
    AddressesService addressesService;

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Addresses addresses) {
        addressesService.addStudent(addresses);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<Addresses> students = addressesService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        Optional<Addresses> old = addressesService.getStudentById(id);
        if (old.isPresent()) {
            addressesService.deleteStudent(id);
            return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND, "Student not found!"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Optional<Addresses> studentObj = addressesService.getStudentById(id);
        if (studentObj.isPresent()) {
            addressesService.deleteStudent(id);
            return new ResponseEntity<>(studentObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND, "Student not found!"), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable Long id, @RequestBody Addresses addresses) {
        Optional<Addresses> old = addressesService.getStudentById(id);
        if (old.isPresent()) {
            if (!addresses.getAddressLine1().isEmpty()) {
                old.get().setAddressLine1(addresses.getAddressLine1());
            } else {
                old.get().setAddressLine1(old.get().getAddressLine1());
            }
            if (!addresses.getAddressLine2().isEmpty()) {
                old.get().setAddressLine2(addresses.getAddressLine2());
            } else {
                old.get().setAddressLine2(old.get().getAddressLine2());
            }
            addressesService.updateStudent(old.get());
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
}
