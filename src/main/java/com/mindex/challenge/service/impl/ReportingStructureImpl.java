package com.mindex.challenge.service.impl;


import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureImpl implements ReportingStructureService, EmployeeService {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    // NOTE: This annotation where lifecycle is passed from service to repository
    @Autowired
    private EmployeeRepository employeeRepository;

    // NOTE: This method helps to find the count for the direct report count

    public void directReportGenerator(Employee employee,ReportingStructure reportingStructure){
        reportingStructure.addTotalDirectReports(employee);
        Employee newEmployee = employeeRepository.findByEmployeeId(employee.getEmployeeId());
           if(newEmployee.getDirectReports() != null && !newEmployee.getDirectReports().isEmpty()){
                for (int itr = 0; itr < newEmployee.getDirectReports().size(); itr++) {
                        directReportGenerator(newEmployee.getDirectReports().get(itr), reportingStructure);
                }
           }
    }

    //NOTE: Overriding the service method

    @Override
    public ReportingStructure getEmployeeDetails(String id) {
        LOG.debug("Get employee details for this id [{}]", id);

        ReportingStructure reportingStructureEmployee = new ReportingStructure();

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("employeeId not found id value is: " + id);
        }
        if(!reportingStructureEmployee.getTotalDirectReports().isEmpty()) {
            reportingStructureEmployee.emptyTotalDirectReports();
        }

        if(employee.getDirectReports() != null && !employee.getDirectReports().isEmpty()){
            for (int itr = 0; itr < employee.getDirectReports().size(); itr++) {

                directReportGenerator(employee.getDirectReports().get(itr), reportingStructureEmployee);
            }
        }
        reportingStructureEmployee.setSuperEmployee(employee);
        reportingStructureEmployee.updateNumberOfReports();

        return reportingStructureEmployee;
    }

    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public Employee read(String id) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }
}
