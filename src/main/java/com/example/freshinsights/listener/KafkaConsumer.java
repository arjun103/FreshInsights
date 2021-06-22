package com.example.freshinsights.listener;

import com.example.freshinsights.dto.DTO;
import com.example.freshinsights.model.Activity;
import com.example.freshinsights.model.Flow;
import com.example.freshinsights.model.Products;

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
    Flow flow = new Flow();
    Products products = new Products();


    @KafkaListener(topics = "FreshInsights", containerGroup = "group_activity", containerFactory = "activityKafkaListenerFactory")
    public void consumeJson(Activity activity)
    {
        System.out.println("Consumed JSON Message: " + activity);
        dto = new DTO(activity, flow, products);
        dto.setIds();
        String message = customService.setData(dto);
        customService.printMessage(dto, message);
    }
}
