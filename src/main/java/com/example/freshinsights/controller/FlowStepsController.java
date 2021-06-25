package com.example.freshinsights.controller;

import com.example.freshinsights.model.FlowSteps;
import com.example.freshinsights.service.FlowStepsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/freshinsights")
public class FlowStepsController
{
    @Autowired
    FlowStepsService flowStepsService;

    @PostMapping("/flowsteps")
    void createFlowSteps(@RequestBody FlowSteps flowSteps)
    {
        flowStepsService.createFlowSteps(flowSteps);
    }

    @GetMapping("/flowsteps")
    List<FlowSteps> findAllFlowSteps()
    {
        return flowStepsService.findAllFlowSteps();
    }

    @DeleteMapping("/flowsteps/{id}/delete")
    void deleteFlowSteps(@PathVariable  BigInteger id)
    {
        flowStepsService.deleteFlowSteps(id);
    }

    @GetMapping("/flowsteps/{id}")
    List<FlowSteps> findFlowStepsDetailsUsingFlowId(@PathVariable("id") BigInteger flowId)
    {
        return flowStepsService.findFlowStepsDetailsUsingFlowId(flowId);
    }
}
