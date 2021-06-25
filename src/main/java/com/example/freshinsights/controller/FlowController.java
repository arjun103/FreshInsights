package com.example.freshinsights.controller;

import com.example.freshinsights.model.Flow;
import com.example.freshinsights.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/freshinsights")
public class FlowController
{
    @Autowired
    FlowService flowService;

    @PostMapping("/flow")
    void createFlow(@RequestBody Flow flow)
    {
        flowService.createFlow(flow);
    }

    @GetMapping("/flows")
    List<Flow> findAllFlows()
    {
        return flowService.findAllFlows();
    }

    @GetMapping("/flow/{id}")
    Flow findFlowByID(@PathVariable BigInteger id)
    {
        return flowService.findFlowByID(id);
    }

    @DeleteMapping("/flow/{id}/delete")
    void deleteFlow(@PathVariable  BigInteger id)
    {
        flowService.deleteFlow(id);
    }
}
