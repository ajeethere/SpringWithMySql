package com.springMySql.SpringMySql.service;


import com.springMySql.SpringMySql.entity.Addresses;
import com.springMySql.SpringMySql.respository.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class AddressesService {
    @Autowired
    AddressesRepository addressesRepository;

    public List<Addresses> getAllStudents(){
        return addressesRepository.findAll();
    }

    public void addStudent(@RequestBody Addresses studentObj){
        addressesRepository.save(studentObj);
    }

    public void deleteStudent(Long id){
        addressesRepository.deleteById(id);
    }

    public void updateStudent(@RequestBody Addresses addresses){
        addressesRepository.save(addresses);
    }

    public Optional<Addresses> getStudentById(Long id){
        return addressesRepository.findById(id);
    }
}
