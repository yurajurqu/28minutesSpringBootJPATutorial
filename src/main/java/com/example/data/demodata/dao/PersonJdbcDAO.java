package com.example.data.demodata.dao;

import com.example.data.demodata.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Person> findAll(){
        return jdbcTemplate.query("SELECT * FROM PERSON",
                new BeanPropertyRowMapper<Person>(Person.class));
    }
    public Person findById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }
    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id= ?",new Object[]{id});
    }
    public int insert(Person person){
        return jdbcTemplate.update("INSERT INTO PERSON(ID,NAME,LOCATION,birth_date) " +
                " VALUES (?,?,?,? );", new Object[]{
                        person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())
        });
    }
    public int update(Person person){
        return jdbcTemplate.update("update person set name = ?, location=?,birth_date=? where id= ?",new Object[]{
                person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()),person.getId()
        });
    }

}
