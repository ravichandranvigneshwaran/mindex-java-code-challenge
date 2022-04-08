package com.mindex.challenge.controller;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

public class CompensationController {
    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private CompensationService compensationService;

    @GetMapping("/findAllCompensation")
    public List<Compensation> getCompensation() {
        return compensationRepository.findAll();
    }

    @GetMapping("/findCompensation/{id}")
    public Compensation getCompensationById(@PathVariable String id) {
        return compensationService.getCompensationById(id);
    }

    @PostMapping("/addCompensation")
    public Employee create(@RequestBody Compensation compensation) {
        return compensationService.createCompensation(compensation);
    }

}
