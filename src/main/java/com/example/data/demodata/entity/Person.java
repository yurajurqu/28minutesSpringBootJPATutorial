package com.example.data.demodata.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name="find_all_people",query = "select p from Person p")
public class Person {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="name")
    private String name;
    private String location;
    private Date birthDate;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthdate) {
        this.birthDate = birthdate;
    }

    public Person(int id, String name, String location, Date birthdate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthdate;
    }
    public Person(String name, String location, Date birthdate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthdate;
    }

    public Person() {
    }
}
