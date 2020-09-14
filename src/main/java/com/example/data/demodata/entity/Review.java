package com.example.data.demodata.entity;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String description;

    @Enumerated(EnumType.STRING)
    private ReviewRating rating;

    @ManyToOne
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ReviewRating getRating() {
        return rating;
    }

    public void setRating(ReviewRating rating) {
        this.rating = rating;
    }

    public Review(String description,ReviewRating rating) {
        this.description = description;
        this.rating=rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Review() {
    }

    @Override
    public String toString() {
        return String.format("Student[%s %s]",rating,description);
    }
}
