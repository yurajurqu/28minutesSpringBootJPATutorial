package com.example.data.demodata.dao;

import com.example.data.demodata.entity.Course;
import com.example.data.demodata.entity.Review;
import com.example.data.demodata.entity.ReviewRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findByid(Long id){
        return em.find(Course.class,id);
    }
    public Course save(Course course){
        if(course.getId()==null){
            em.persist(course);
        }else {
            em.merge(course);
        }
        return course;
    }
    public void deleteById(Long id){
        em.remove(findByid(id));
    }
    public List<Course> findAll(){
        return em.createNamedQuery("all_courses",Course.class).getResultList();
    }

    public void playWithEntityManager(){
        logger.info("playWithEntityManager - start");
        Course course = new Course("Web Services in 100 steps");
        em.persist(course);
        em.flush();
        Course course2 = new Course("Angular in 100 steps");
        em.persist(course2);
        em.flush();
        course.setName("Web Services in 100 steps - updated");
        course2.setName("Angular in 100 steps - updated" );
        em.refresh(course);
    }

    public void addReviewForCourse(){
        Course course= findByid(10003L);
        logger.info("course reviews {}",course.getReviews());

        Review review1 = new Review("fine by me", ReviewRating.FOUR);
        Review review2 = new Review("fine by somebody else",ReviewRating.TWO);

        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        em.persist(review1);
        em.persist(review2);

    }
    public void addReviewsForCourse(Long courseId,List<Review> reviews){
        Course course= findByid(courseId);
        logger.info("course reviews {}",course.getReviews());
        for (Review review:reviews             ) {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }

    public void playWithReviewEnum(){
        Review awesomeReview = new Review("awesome", ReviewRating.FIVE);
        em.persist(awesomeReview);
        awesomeReview.setRating(ReviewRating.ONE);
        em.merge(awesomeReview);
    }

}
