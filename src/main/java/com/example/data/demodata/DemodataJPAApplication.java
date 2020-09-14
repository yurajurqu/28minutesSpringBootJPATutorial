package com.example.data.demodata;

import com.example.data.demodata.dao.*;
import com.example.data.demodata.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemodataJPAApplication implements CommandLineRunner {


    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(DemodataJPAApplication.class, args);
    }

    @Autowired
    PersonJPARepository repository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EntityManager em;

    @Override
    public void run(String... args) throws Exception {

        courseRepository.playWithReviewEnum();

        /*
        employeeRepository.insert(new PartTimeEmployee("Jill",
                new BigDecimal("50")));
        employeeRepository.insert(new FullTimeEmployee("Jack",
                new BigDecimal("1000")));
        logger.info("all fulltime employees -> {}",employeeRepository.retrieveAllFullTimeEmployees());
        logger.info("all parttime employees -> {}",employeeRepository.retrieveAllPartTimeEmployees());
        studentRepository.insertStudentAndCourse();
        List<Review> reviews= Arrays.asList(new Review("fine by me","3"),new Review("fine by somebody else","1"));
        courseRepository.addReviewsForCourse(10003L,reviews);
        courseRepository.addReviewForCourse();
        studentRepository.saveStudentWithPassport();
        courseRepository.playWithEntityManager();
        logger.info("course 10001L -> {}",courseRepository.findByid(10001L));
        courseRepository.deleteById(10001L);
        logger.info("all courses -> {}",courseRepository.findAll());

        logger.info("User id 10001 -> {}",repository.findById(10001)) ;
        logger.info("User new 10004 -> {}",repository.insert(new Person(10004,"xxx","yyy",new Date(System.currentTimeMillis()))));
        logger.info("User update  10003 -> {}",repository.update(new Person(10003,"dddd","jjjj",new Date(System.currentTimeMillis()))));
        repository.deleteById(10002);
        logger.info("all people -> {}",repository.findAll());
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
*/

        System.out.println("Running command line");
    }
}
