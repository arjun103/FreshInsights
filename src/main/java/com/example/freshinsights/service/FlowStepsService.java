package com.example.freshinsights.service;

import com.example.freshinsights.model.FlowSteps;
import com.example.freshinsights.repository.FlowStepsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FlowStepsService
{
    @Autowired
    FlowStepsRepository flowStepsRepository;

    public void createFlowSteps(FlowSteps flowSteps) {
        flowStepsRepository.save(flowSteps);}

    public void deleteFlowSteps(BigInteger id) {
        flowStepsRepository.deleteById(id);
    }

    public List<FlowSteps> findAllFlowSteps() {return (List<FlowSteps>) flowStepsRepository.findAll();
    }

    public FlowSteps findFlowStepsByID(BigInteger id) {return flowStepsRepository.findById(id).get();
    }
}
