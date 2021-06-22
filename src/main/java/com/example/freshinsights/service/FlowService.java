package com.example.freshinsights.service;

import com.example.freshinsights.model.Flow;
import com.example.freshinsights.model.FlowSteps;
import com.example.freshinsights.repository.FlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FlowService
{
    @Autowired
    FlowRepository flowRepository;

    public void createFlow(Flow flow) {
        flowRepository.save(flow);}

    public void deleteFlow(BigInteger id) {
        flowRepository.deleteById(id);
    }

    public List<Flow> findAllFlows() {return (List<Flow>) flowRepository.findAll();
    }

    public Flow findFlowByID(BigInteger id) {return flowRepository.findById(id).get();
    }

    public List<Flow> findFlowDetailsUsingFlowId(BigInteger flowId) {
        for(Flow flow:(List<Flow>) flowRepository.findFlowDetailsUsingFlowId(flowId))
        {
            System.out.println(flow.toString());
        }
        return (List<Flow>) flowRepository.findFlowDetailsUsingFlowId(flowId);
    }
}
