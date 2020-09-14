package com.example.data.demodata.dao;

import com.example.data.demodata.DemodataJPAApplication;
import com.example.data.demodata.entity.Address;
import com.example.data.demodata.entity.Course;
import com.example.data.demodata.entity.Passport;
import com.example.data.demodata.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= DemodataJPAApplication.class)
class StudentRepositoryTest { private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void findById_basic() {
        Student student = em.find(Student.class, 20001L);
        logger.info("Student -> {}",student);
        logger.info("Student passport-> {}",student.getPassport());
    }
    @Test
    @Transactional
    void findById_basic_address_details() {
        Student student = em.find(Student.class, 20001L);
        Address address = new Address("line1", "lin2", "city");
        student.setAddress(address);
        em.flush();
        logger.info("Student -> {}",student);
        logger.info("Student passport-> {}",student.getPassport());
        logger.info("student address city-> {}",student.getAddress().getCity());

    }
    @Test
    @Transactional
    void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}",passport);
        logger.info("passport student-> {}",passport.getStudent());
    }
    @Test
    @Transactional
    void retrieveStudentAndCourses() {

        Student student=em.find(Student.class,20001L);
        logger.info("student -> {}",student);
        logger.info("student -> courses-> {}",student.getCourses());
    }@Test
    @Transactional
    void retrieveCourseAndStudents() {

        Course course=em.find(Course.class,10001L);
        logger.info("course -> {}",course);
        logger.info("course -> students-> {}",course.getStudents());
    }
    @Test
    void someTest() {
        studentRepository.someDummyOperationToUnderstandPersistenceContext();
    }



}
