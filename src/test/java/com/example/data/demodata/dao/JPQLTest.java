package com.example.data.demodata.dao;

import com.example.data.demodata.DemodataJPAApplication;
import com.example.data.demodata.entity.Course;
import com.example.data.demodata.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest(classes= DemodataJPAApplication.class)
public class JPQLTest {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpql_basic(){
        List resultList = em.createNamedQuery("query_get_all_courses").getResultList();
        logger.info("query: {} -> {} ","query_get_all_courses",resultList);
    }
    @Test
    public void jpql_typed(){
        String query = "select c from Course c";
        TypedQuery<Course> query1 = em.createQuery(query, Course.class);
        List<Course> courses = query1.getResultList();
        logger.info("query: {} -> {} ",query, courses);
    }
    @Test
    public void jpql_where(){
        TypedQuery<Course> query1 = em.createNamedQuery("100_step_courses", Course.class);
        List<Course> courses = query1.getResultList();
        logger.info("query: {} -> {} ","100_step_courses", courses);
    }
    @Test
    public void course_with_no_students(){
        TypedQuery<Course> query1 = em.createQuery("select c from Course c where c.students is empty", Course.class);
        List<Course> courses = query1.getResultList();
        logger.info("query: {} -> {} ","courses with no students", courses);
    }
    @Test
    public void course_with_more_than_two_students(){
        TypedQuery<Course> query1 = em.createQuery("select c from Course c where size(c.students) >=2", Course.class);
        List<Course> courses = query1.getResultList();
        logger.info("query: {} -> {} ","courses with no students", courses);
    }
    @Test
    public void courses_ordered_by_number_students(){
        TypedQuery<Course> query1 = em.createQuery("select c from Course c order by size(c.students) desc", Course.class);
        List<Course> courses = query1.getResultList();
        logger.info("query: {} -> {} ","courses_ordered_by_number_students", courses);
    }
    @Test
    public void students_with_passport_containing_1234(){
        TypedQuery<Student> query1 = em.createQuery("select s from Student s where s.passport.number like '%1234%'", Student.class);
        List<Student> courses = query1.getResultList();
        logger.info("query: {} -> {} ","students_with_passport_containing_1234", courses);
    }
    @Test
    public void join(){
        Query query = em.createQuery("select c,s from Course c JOIN c.students s");
        List<Object[]>  resultList = query.getResultList();
        logger.info("Result size -> {}",resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course {} student {} ",result[0],result[1]);
        }
    }
    @Test
    public void left_join(){
        Query query = em.createQuery("select c,s from Course c LEFT JOIN c.students s");
        List<Object[]>  resultList = query.getResultList();
        logger.info("Result size -> {}",resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course {} student {} ",result[0],result[1]);
        }
    }@Test
    public void cross_join(){
        Query query = em.createQuery("select c,s from Course c ,Student s");
        List<Object[]>  resultList = query.getResultList();
        logger.info("Result size -> {}",resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course {} student {} ",result[0],result[1]);
        }
    }


}
