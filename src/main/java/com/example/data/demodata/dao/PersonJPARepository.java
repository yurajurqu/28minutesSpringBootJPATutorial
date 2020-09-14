package com.example.data.demodata.dao;

import com.example.data.demodata.entity.Person;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJPARepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_people", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }
    public Person update(Person person){
        return entityManager.merge(person);
    }
    public Person insert(Person person){
        return entityManager.merge(person);
    }
    public void deleteById(int id){
        entityManager.remove(findById(id));
    }
}
