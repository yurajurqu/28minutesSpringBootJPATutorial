package com.example.data.demodata;

import com.example.data.demodata.dao.PersonJdbcDAO;
import com.example.data.demodata.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

//@SpringBootApplication
//implements CommandLineRunner
public class DemodataApplication  {

/*
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(DemodataApplication.class, args);
    }

    @Autowired
    PersonJdbcDAO dao;

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}",dao.findAll()) ;
        logger.info("Id 10001 -> {}",dao.findById(10001)) ;
        logger.info("Remove 10001 -> {}",dao.deleteById(10001)) ;
        Person person = new Person();
        person.setId(10009);
        person.setLocation("Trujillo Colombia");
        person.setName("Variable");
        person.setBirthDate(new Date(System.currentTimeMillis()));
        logger.info("add person id {}",dao.insert(person));
        dao.update(new Person(10002,"xxx","yyy",new Date(System.currentTimeMillis())));
        logger.info("All users -> {}",dao.findAll()) ;


        System.out.println("Running command line");
    }

 */
}
