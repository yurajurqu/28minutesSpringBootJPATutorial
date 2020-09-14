package com.example.data.demodata.dao;

import com.example.data.demodata.DemodataJPAApplication;
import com.example.data.demodata.entity.Course;
import com.example.data.demodata.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= DemodataJPAApplication.class)
class CourseSprintDataRepositoryTest {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    void findById_coursePresent() {
        Optional<Course> courseOptional= repository.findById(1001L);
        logger.info("{}",courseOptional.isPresent());
        assertTrue(courseOptional.isPresent());
    }
    @Test
    void findById_courseNotPresent() {
        Optional<Course> courseOptional= repository.findById(10001L);
        logger.info("{}",courseOptional.isPresent());
        assertFalse(courseOptional.isPresent());
    }
    @Test
    void playingAroundWithSpringDataRepository() {
        Course course = new Course("Microservices in 100 steps");
        repository.save(course);
        course.setName("Microservices in 100 steps - updated");
        repository.save(course);
        logger.info("Courses -> {}",repository.findAll());
        logger.info("Courses -> {}",repository.count());
    }
    @Test
    void sort() {
        Sort sort= Sort.by(Sort.Direction.ASC,"name").and(Sort.by(Sort.Direction.DESC,"id"));
        logger.info("Sorted Courses -> {}",repository.findAll(sort));
        logger.info("Courses #-> {}",repository.count());
    }
    @Test
    void pagination() {
        PageRequest pageRequest =  PageRequest.of(0, 3);
        Page<Course> firstPage = repository.findAll(pageRequest);
        logger.info("First page-> {}", firstPage.getContent());
        Pageable secondPageRequest = firstPage.getPageable().next();
        Page<Course> secondPage = repository.findAll(secondPageRequest);
        logger.info("Second page-> {}", secondPage.getContent());
    }
    @Test
    void customQuerySpringDataJpa() {
        List<Course> courses = repository.findByName("JPA in 50 steps");
        logger.info("Courses -> {}",courses);
        logger.info("Courses -> {}",repository.countByName("JPA in 50 steps"));
        logger.info("Courses -> {}",repository.coursesWith100StepsInName());
        logger.info("Courses -> {}",repository.coursesWith100StepsInNameUsingNativeQuery());
    }

}
