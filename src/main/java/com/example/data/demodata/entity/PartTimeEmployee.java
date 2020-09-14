package com.example.data.demodata.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee {

    private BigDecimal hourlyWage;

    protected PartTimeEmployee(){}

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
