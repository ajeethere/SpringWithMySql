package com.springMySql.SpringMySql.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping
    public String getHello() {
        return "HELLO WORLD";
    }

    @GetMapping("/test")
    public String test() {
        return "TEST HELLO WORLD";
    }

    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.setAge(20);
        person.setName("Sonu");
        return person;
    }

    @GetMapping("/personList")
    public List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.setAge(20);
        person1.setName("Sonu");
        Person person2 = new Person();
        person2.setAge(30);
        person2.setName("Sonudi");
        personList.add(person1);
        personList.add(person2);
        return personList;
    }



}

@Setter
@Getter
class Person{
    private String name;
    private int age;

}
