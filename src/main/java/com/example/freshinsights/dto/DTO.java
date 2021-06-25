package com.example.freshinsights.dto;

import com.example.freshinsights.model.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTO
{
    Consumer consumer;
    Activity activity;
    Flow flow;
    Products products;
    FlowSteps flowSteps;

    public DTO(Consumer consumer,Activity activity, Flow flow, Products products, FlowSteps flowSteps)
    {
        this.consumer = consumer;
        this.activity = activity;
        this.flow = flow;
        this.products = products;
        this.flowSteps = flowSteps;
    }

    public void setData()
    {
        activity.setProductId(consumer.getId());
        products.setProductId(consumer.getId());
        flow.setProductId((consumer.getId()));
        activity.setMailId(consumer.getEmail());
        flowSteps.setStepDescription(consumer.getEvent());
    }
}
