package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DataBootstrap {
    private static final String DATASTORE_LOCATION = "/static/employee_database.json";
    private static final String COMPENSATION_DATASTORE_LOCATION = "/static/compensation_database.json";


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        // NOTE: inputStream declaration for reading the json
        InputStream inputStream = this.getClass().getResourceAsStream(DATASTORE_LOCATION);

        //NOTE: Logger variable declaration
        final Logger LOG = LoggerFactory.getLogger(DataBootstrap.class);

        // NOTE: inputStream declaration for reading the json
        InputStream compensationInputStream = this.getClass().getResourceAsStream(COMPENSATION_DATASTORE_LOCATION);

        //NOTE: Variable declaration
        Employee[] employees = null;
        Compensation[] compensations = null;

        //NOTE: creating basic data for the Employee entity from the JSON
        try {
            employees = objectMapper.readValue(inputStream, Employee[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Employee employee : employees) {
            employeeRepository.insert(employee);
        }

        //NOTE: creating basic data for the Compensation entity from the JSON
        try {
            compensations = objectMapper.readValue(compensationInputStream, Compensation[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Compensation compensation : compensations) {
            compensationRepository.insert(compensation);
        }

    }
}
