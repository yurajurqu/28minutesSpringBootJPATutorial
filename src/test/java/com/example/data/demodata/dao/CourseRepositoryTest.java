package com.example.data.demodata.dao;

import com.example.data.demodata.DemodataJPAApplication;
import com.example.data.demodata.entity.Course;
import com.example.data.demodata.entity.Review;
import com.example.data.demodata.entity.ReviewRating;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= DemodataJPAApplication.class)
class CourseRepositoryTest { private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;


    @Autowired
    EntityManager em;

    @Test
    void findById_basic() {
        logger.info("all -> {}",repository.findAll());
        Course course = repository.findByid(10002L);
        assertNotNull(course);
        assertEquals("Spring Boot 2 in action",course.getName());
        logger.info("Test is running");
    }
 @Test
 //@Transactional
    void findById_firstLevelCache() {
        logger.info("all -> {}",repository.findAll());
        logger.info("First course retrievedd");
        Course course = repository.findByid(10002L);
        assertNotNull(course);
        assertEquals("Spring Boot 2 in action",course.getName());
        logger.info("First course retrieved again");
        Course course1 = repository.findByid(10002L);
        assertEquals("Spring Boot 2 in action",course1.getName());
        logger.info("Test is running");
    }

    @Test
    public void enumTest(){

    }

    @Test
    @DirtiesContext
    //@Transactional
    void deleteById_basic(){
        repository.deleteById(10002L);
        //List<Course> all = repository.findAll();
        //assertEquals(1,all.size());
        assertNull(repository.findByid(10002L));

    }

    @Test
    @DirtiesContext
    void save_new_basic(){
        Course newCourse = new Course("Chemistry");
        Course course = repository.save(newCourse);
        assertNotNull(course);
        Course c =repository.findByid(course.getId());
        assertEquals("Chemistry",c.getName());
    }
    @Test
    @DirtiesContext
    void save_update_basic(){
        Course c =repository.findByid(10003L);
        c.setName("Java EE");
        repository.save(c);
        assertEquals("Java EE",repository.findByid(10003L).getName());
    }
    @Test
    @DirtiesContext
    void playWithEntityManager(){
        repository.playWithEntityManager();
    }
    @Test
    @DirtiesContext
    @Transactional
    void retrieveReviewsForCourse(){
        Course course= repository.findByid(10001L);
        logger.info("{}",course.getReviews());
    }
    @Test
    @DirtiesContext
    @Transactional(isolation = Isolation.READ_COMMITTED)
    void retrieveCourseForReview(){
        Review review = em.find(Review.class,50001L);
        logger.info("{}",review.getCourse());
    }

}
