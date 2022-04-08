package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {

    // NOTE: This annotation where lifecycle is passed from service to repository
    @Autowired
    private CompensationRepository compensationRepository;

    //NOTE: Overriding the service method
    @Override
    public Compensation createCompensation(Compensation compensation) {
        return compensationRepository.insert(compensation);
    }

    @Override
    public Compensation getCompensationById(String id) {
        return compensationRepository.findByEmployeeId(id);
    }
}
