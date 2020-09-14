package com.example.data.demodata.dao;

import com.example.data.demodata.DemodataJPAApplication;
import com.example.data.demodata.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest(classes= DemodataJPAApplication.class)
public class NativeQueryTest {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void native_queries_basic(){
        List resultList = em.createNativeQuery("select * from course where is_deleted=0",Course.class).getResultList();
        logger.info("query: {} -> {} ","select * from course",resultList);
    }
    @Test
    public void native_queries_basic_parameter(){
        Query query = em.createNativeQuery("select * from course where id=?", Course.class);
        query.setParameter(1,10001L);
        logger.info("query: {} -> {} ","select * from course",query.getResultList());
    }
    @Test
    public void native_queries_basic_named_parameter(){
        Query query = em.createNativeQuery("select * from course where id=:id", Course.class);
        query.setParameter("id",10001L);
        logger.info("query: {} -> {} ","select * from course",query.getResultList());
    }
    @Test
    @Transactional
    public void native_queries_to_update(){
        Query query = em.createNativeQuery("update course set last_updated_date=sysdate()");
        int rows=query.executeUpdate();
        logger.info("rows updated: {} -> {} ","select * from course",rows);
    }

}
