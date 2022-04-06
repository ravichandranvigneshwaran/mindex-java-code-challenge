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

    @Autowired
    private EmployeeRepository employeeRepository;

    public void directReportGenerator(Employee employee,ReportingStructure reportingStructure){
        reportingStructure.addTotalDirectReports(employee);
        Employee newEmployee = employeeRepository.findByEmployeeId(employee.getEmployeeId());
           if(newEmployee.getDirectReports() != null && !newEmployee.getDirectReports().isEmpty()){
                for (int itr = 0; itr < newEmployee.getDirectReports().size(); itr++) {
                        directReportGenerator(newEmployee.getDirectReports().get(itr), reportingStructure);
                }
           }
    }

    @Override
    public ReportingStructure getEmployeeDetails(String id) {
        LOG.debug("Get employee details for this id [{}]", id);

        ReportingStructure employee2 = new ReportingStructure();

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("employeeId not found id value is: " + id);
        }
        if(!employee2.getTotalDirectReports().isEmpty()) {
            employee2.emptyTotalDirectReports();
        }

        if(employee.getDirectReports() != null && !employee.getDirectReports().isEmpty()){
            for (int itr = 0; itr < employee.getDirectReports().size(); itr++) {

                directReportGenerator(employee.getDirectReports().get(itr), employee2);
            }
        }
        employee2.setSuperEmployee(employee);
        employee2.updateNumberOfReports();

        return employee2;
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
