package com.example.data.demodata.dao;

import com.example.data.demodata.entity.Course;
import com.example.data.demodata.entity.Passport;
import com.example.data.demodata.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findByid(Long id){
        return em.find(Student.class,id);
    }
    public Student save(Student student){
        if(student.getId()==null){
            em.persist(student);
        }else {
            em.merge(student);
        }
        return student;
    }
    public void deleteById(Long id){
        em.remove(findByid(id));
    }
    public List<Student> findAll(){
        return em.createNamedQuery("all_students",Student.class).getResultList();
    }

    public void saveStudentWithPassport(){

        Passport passport=new Passport("Z123434");
        em.persist(passport);
        Student student= new Student("Omar");
        student.setPassport(passport);
        em.persist(student);
    }

    public void someDummyOperationToUnderstandPersistenceContext() {
        Student student=em.find(Student.class,20001L);
        Passport passport=student.getPassport();

        passport.setNumber("E123453");

        student.setName("Ranga - updated");
    }
    public void insertStudentAndCourse(){
        Student student= new Student("Jack");
        Course course= new Course("Microservices in 100 steps");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        em.persist(student);
    }
}
