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
public class CriteriaQueryTest {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void criteria_query_basic(){



        TypedQuery query = em.createQuery("select c from Course c",Course.class);
        List<Course> resultList=query.getResultList();
        logger.info("query: {} -> {} ","query_get_all_courses",resultList);
    }
}
