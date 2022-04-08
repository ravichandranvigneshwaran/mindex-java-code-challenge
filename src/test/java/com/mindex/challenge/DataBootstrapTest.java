package com.mindex.challenge;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.ReportingStructureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ReportingStructureService reportingStructureService;

    @Autowired
    private CompensationService compensationService;

    @Test
    public void test() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());

        ReportingStructure reportingStructure = reportingStructureService.getEmployeeDetails("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", reportingStructure.getFirstName());
        assertEquals("Lennon", reportingStructure.getLastName());
        assertEquals("Development Manager", reportingStructure.getPosition());
        assertEquals("Engineering", reportingStructure.getDepartment());
        assertEquals(4, reportingStructure.getNumberOfReports());


        // Test to find if find Compensation by ID
        Compensation compensationTest1 = compensationService.getCompensationById("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", compensationTest1.getFirstName());
        assertEquals("Lennon", compensationTest1.getLastName());
        assertEquals("Development Manager", compensationTest1.getPosition());
        assertEquals("Engineering", compensationTest1.getDepartment());
        assertEquals(23000, compensationTest1.getSalary());
        assertEquals("2020-02-20", compensationTest1.getEffectiveDate());

    }
}