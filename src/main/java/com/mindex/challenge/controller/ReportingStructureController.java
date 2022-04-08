package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Note: In Spring boot Controller is used for processing request till returning the request

//Note: this tells that the class is a controller
@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    // NOTE: This annotation where lifecycle is passed from controller to service
    @Autowired
    private ReportingStructureService reportingStructureService;

    // Note: this annotations for GET Method helps the controller to forward the url pattern to the method.
    // USAGE: For getting only one data based on the id from the entity
    @GetMapping("/reportingStructure/{id}")
    public Employee getEmployeeDetails(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return reportingStructureService.getEmployeeDetails(id);
    }
}
