package com.mindex.challenge.data;

import java.util.List;

public class Employee {

    //NOTE: Variable declaration for the class
    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private List<Employee> directReports;

    //NOTE: Constructor for the class
    public Employee() {
    }

    // Getters and Setters for the class
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }

    public void setEmployee(Employee employee){
        setEmployeeId(employee.getEmployeeId());
        setFirstName(employee.getFirstName());
        setLastName(employee.getLastName());
        setPosition(employee.getPosition());
        setDepartment(employee.getDepartment());
        setDirectReports(employee.getDirectReports());
    }
}
