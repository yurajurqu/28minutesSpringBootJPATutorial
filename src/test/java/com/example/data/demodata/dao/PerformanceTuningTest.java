package com.example.data.demodata.dao;

import com.example.data.demodata.DemodataJPAApplication;
import com.example.data.demodata.entity.Course;
import com.example.data.demodata.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= DemodataJPAApplication.class)
class PerformanceTuningTest {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void solvingNPlusOneProblem() {
        List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class).getResultList();
        for (Course course :courses) {
            logger.info("Course -> {} Students -> {}",course,course.getStudents());
        }
    }
    @Test
    @Transactional
    void solvingNPlusOneProblem_EntityGraphSolution() {
        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
        entityGraph.addSubgraph("students");
        List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class)
                .setHint("javax.persistence.loadgraph",entityGraph)
                .getResultList();
        for (Course course :courses) {
            logger.info("Course -> {} Students -> {}",course,course.getStudents());
        }
    }
    @Test
    @Transactional
    void solvingNPlusOneProblem_JoinFetch() {
        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
        entityGraph.addSubgraph("students");
        List<Course> courses = em.createNamedQuery("query_get_all_courses_join_fetch", Course.class)
                .getResultList();
        for (Course course :courses) {
            logger.info("Course -> {} Students -> {}",course,course.getStudents());
        }
    }


}
