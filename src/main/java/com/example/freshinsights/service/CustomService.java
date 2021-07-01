package com.example.freshinsights.service;

import com.example.freshinsights.ActivityStatus;
import com.example.freshinsights.dto.DTO;
import com.example.freshinsights.model.Activity;
import com.example.freshinsights.model.Flow;
import com.example.freshinsights.model.FlowSteps;
import com.example.freshinsights.model.Products;
import com.example.freshinsights.repository.ActivityRepository;
import com.example.freshinsights.repository.FlowRepository;
import com.example.freshinsights.repository.FlowStepsRepository;
import com.example.freshinsights.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomService
{
    String string;
    String to;
    List<Activity> activityList;

    Products products = new Products();
    Flow flow = new Flow();
    FlowSteps flowSteps = new FlowSteps();
    Activity activity = new Activity();

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    FlowStepsRepository flowStepsRepository;

    @Autowired
    FlowRepository flowRepository;

    @Autowired
    ActivityRepository activityRepository;

    public String processData(DTO dto)
    {

        if(!productsRepository.existsById(dto.getProducts().getProductId()))
        {
            return "Invalid productId";
        }
        else
        {
            System.out.println("Given productId exists");
        }

        products = productsRepository.findProductDeatilsUsingId(dto.getProducts().getProductId());
        flow = flowRepository.findFlowDetailsUsingCustomDetails(dto.getFlow().getProductId(), dto.getFlowSteps().getStepDescription());
        flowSteps = flowStepsRepository.findFlowStepsDetailsUsingCustomDetails(dto.getFlow().getProductId(), dto.getFlowSteps().getStepDescription());

        dto.getProducts().setProductName(products.getProductName());

        dto.getFlow().setFlowId(flow.getFlowId());
        dto.getFlow().setFlowDescription(flow.getFlowDescription());
        dto.getFlow().setTotalSteps(flow.getTotalSteps());

        dto.getFlowSteps().setStepNo(flowSteps.getStepNo());
        dto.getFlowSteps().setFlowId(flowSteps.getFlowId());

        dto.getActivity().setFlowId(flow.getFlowId());
        dto.getActivity().setStepsCompleted(flowSteps.getStepNo());

        if(dto.getFlowSteps().getStepNo() == 1)
        {
            activityList = activityRepository.findActivityDetailsByCustom(dto.getActivity().getProductId(), dto.getActivity().getFlowId(), dto.getActivity().getMailId(), ActivityStatus.IN_PROGRESS.name());
            for(Activity activity : activityList)
            {
                System.out.println(activity);
                activityRepository.deleteById(activity.getId());
            }
            dto.getActivity().setCreatedAt();
            dto.getActivity().setUpdatedAt();
            dto.getActivity().setActivityStatus(ActivityStatus.IN_PROGRESS.name());
            activityRepository.save(dto.getActivity());
            return "Unsuccessful completion";

        }
        else if(dto.getFlow().getTotalSteps() == dto.getFlowSteps().getStepNo())
        {
            activity = activityRepository.findActivityDetailsByCustom(dto.getActivity().getProductId(), dto.getActivity().getFlowId(), dto.getActivity().getStepsCompleted()-1, dto.getActivity().getMailId());
            activity.setUpdatedAt();
            activity.setStepsCompleted(dto.getFlowSteps().getStepNo());
            activity.setActivityStatus(ActivityStatus.COMPLETED.name());
            activityRepository.save(activity);
            return "Successful completion";
        }
        else
        {
            activity = activityRepository.findActivityDetailsByCustom(dto.getActivity().getProductId(), dto.getActivity().getFlowId(), dto.getActivity().getStepsCompleted()-1, dto.getActivity().getMailId());
            activity.setUpdatedAt();
            activity.setStepsCompleted(dto.getFlowSteps().getStepNo());
            activityRepository.save(activity);
            return "Unsuccessful completion";

        }
    }

    public void printMessage(DTO dto, String message)
    {
        switch(message)
        {
            case "Invalid productId" :
                System.out.println("INVALID INPUT : Given productId does not exist"); break;

            case "Invalid record":
                System.out.println("INVALID INPUT : FlowSteps/Event continuity not maintained. Multiple record(s) skipped...");

            case "Successful completion" :
                string = "Message : " + dto.getActivity().getMailId() + " has successfully completed the " + dto.getFlow().getFlowDescription() + " for the product : " + dto.getProducts().getProductName();
                System.out.println(string);
//                sendMail(dto, string, "Successful flow completion");
                break;

            case "Unsuccessful completion" :
                string = "Message : " + dto.getActivity().getMailId() + " has not completed the " + dto.getFlow().getFlowDescription() + " for the product : " + dto.getProducts().getProductName();
                System.out.println(string);
//                sendMail(dto, string, "Unsuccessful flow completion");
                break;
        }
    }

    @Scheduled(fixedRate = 60000)
    public void sendMail(DTO dto, String string, String sub)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        to = dto.getActivity().getMailId();
        mailMessage.setTo(to);
        mailMessage.setSubject(sub);
        mailMessage.setText(string);
        mailSender.send(mailMessage);
    }
}
