package com.mindex.challenge.data;

import java.util.ArrayList;
import java.util.List;

public class ReportingStructure extends Employee{
    List<Employee> totalDirectReports;
    int numberOfReports;

    public ReportingStructure(){
        totalDirectReports = new ArrayList<Employee>(){};
    }
    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public void setSuperEmployee(Employee employee){
        setEmployee(employee);
    }
    public void updateNumberOfReports(){
        setNumberOfReports(this.totalDirectReports.size());
    }
    public void emptyTotalDirectReports(){
        this.totalDirectReports.clear();
    }
    public void addTotalDirectReports(Employee employee){
        this.totalDirectReports.add(employee);
    }
    public List<Employee> getTotalDirectReports() {
        return totalDirectReports;
    }

}
