package com.mindex.challenge.controller;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Note: In Spring boot Controller is used for processing request till returning the request

//Note: this tells that the class is a controller
@RestController

public class CompensationController {
    // NOTE: This annotation where lifecycle is passed from controller to repository
    @Autowired
    private CompensationRepository compensationRepository;

    // NOTE: This annotation where lifecycle is passed from controller to service
    @Autowired
    private CompensationService compensationService;

    // Note: this annotations for GET Method helps the controller to forward the url pattern to the method.
    // USAGE: For getting all the data from the entity
    @GetMapping("/findAllCompensation")
    public List<Compensation> getAllCompensation() {
        return compensationRepository.findAll();
    }

    // Note: this annotations for GET Method helps the controller to forward the url pattern to the method.
    // USAGE: For getting only one data based on the id from the entity
    @GetMapping("/findCompensation/{id}")
    public Compensation getCompensationById(@PathVariable String id) {
        return compensationService.getCompensationById(id);
    }

    // Note: this annotations for POST Method helps the controller to forward the url pattern to the method.
    // USAGE: For adding data to the entity
    @PostMapping("/addCompensation")
    public Compensation create(@RequestBody Compensation compensation) {
        return compensationService.createCompensation(compensation);
    }

}
