package com.example.data.demodata.dao;

import com.example.data.demodata.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path ="courses" )
public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {
    List<Course> findByName(String name);
    List<Course> deleteByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);
    Long countByName(String name);
    List<Course> countByNameAndId(String name,Long id);
    @Query("Select c from Course c where name like '%50 steps%'")
    List<Course> coursesWith100StepsInName();
    @Query(value="Select * from course c where c.name like '%50 steps%'",nativeQuery = true)
    List<Course> coursesWith100StepsInNameUsingNativeQuery();
    @Query(name = "nameQueryName")
    List<Course> namedQuery();
}
