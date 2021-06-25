package com.example.freshinsights.listener;

import com.example.freshinsights.dto.DTO;
import com.example.freshinsights.model.*;
import com.example.freshinsights.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer
{
    @Autowired
    CustomService customService;

    DTO dto;

    @KafkaListener(topics = "FreshInsights", containerGroup = "group_freshinsights", containerFactory = "KafkaListenerFactory")
    public void consumeJson(Consumer consumer)
    {
        Activity activity = new Activity();
        Flow flow = new Flow();
        Products products = new Products();
        FlowSteps flowSteps = new FlowSteps();
        System.out.println("Consumed JSON Message: " + consumer);
        dto = new DTO(consumer, activity, flow, products, flowSteps);
        dto.setData();
        String message = customService.processData(dto);
        customService.printMessage(dto, message);
    }
}
