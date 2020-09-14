package com.example.data.demodata.controller;

import com.example.data.demodata.dao.PersonJdbcDAO;
import com.example.data.demodata.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonJdbcDAO personJdbcDAO;

    @GetMapping("/people")
    public List<Person> findAll(){
        return personJdbcDAO.findAll();
    }
    @GetMapping("/people/{id}")
    public Person findAll(@PathVariable int id){
        return personJdbcDAO.findById(id);
    }
}
