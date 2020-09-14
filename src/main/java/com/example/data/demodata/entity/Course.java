package com.example.data.demodata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "all_courses",query = "select c from Course c")
@NamedQuery(name = "query_get_all_courses",query = "select c from Course c")
@NamedQuery(name = "query_get_all_courses_join_fetch",query = "select c from Course c JOIN FETCH c.students s")
@NamedQuery(name = "100_step_courses",query = "select c from Course c where name like '%100 steps%'")
@NamedQuery(name = "nameQueryName",query = "select c from Course c where name like '%100 steps%'")
@Cacheable
@SQLDelete(sql="update course set is_deleted = true where id=? ")
@Where(clause = "is_deleted=false")
public class Course {
    private static Logger LOGGER= LoggerFactory.getLogger(Course.class);

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToMany(mappedBy="course")
    private List<Review> reviews= new ArrayList<>();


    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students= new ArrayList<>();

    public List<Review> getReviews() {
        return reviews;
    }

    private boolean isDeleted;

    public void addReview(Review review) {
        this.reviews.add(review);
    }
    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @PreRemove
    private void preRemove(){
        LOGGER.info("Setting isDeleted to true");
        this.isDeleted=true;
    }
}
