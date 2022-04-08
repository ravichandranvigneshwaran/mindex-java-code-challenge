package com.mindex.challenge.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Compensation")
public class Compensation extends Employee{
    private Employee employee;
    private int salary;
    private String effectiveDate;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String expectedDate) {
        this.effectiveDate = expectedDate;
    }
}
