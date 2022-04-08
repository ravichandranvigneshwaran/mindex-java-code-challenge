package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

//Note: In Spring boot Controller is used for processing request till returning the request

//Note: this tells that the class is a controller
@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    // NOTE: This annotation where lifecycle is passed from controller to service
    @Qualifier("employeeServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    // Note: this annotations for POST Method helps the controller to forward the url pattern to the method.
    // USAGE: For adding data to the entity
    @PostMapping("/employee")
    // Note: this is a basic create function which is then overridden by employeeService create
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    // Note: this annotations for GET Method helps the controller to forward the url pattern to the method.
    // USAGE: For get data based on the id from the entity
    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return employeeService.read(id);
    }

    // Note: this annotations for PUT Method helps the controller to forward the url pattern to the method.
    // USAGE: For updating data based on the id from the entity
    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }
}
