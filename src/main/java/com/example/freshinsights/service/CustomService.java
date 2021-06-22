package com.example.freshinsights.service;

import com.example.freshinsights.dto.DTO;
import com.example.freshinsights.model.Flow;
import com.example.freshinsights.model.FlowSteps;
import com.example.freshinsights.model.Products;
import com.example.freshinsights.repository.ActivityRepository;
import com.example.freshinsights.repository.FlowRepository;
import com.example.freshinsights.repository.FlowStepsRepository;
import com.example.freshinsights.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomService {

    List<Products> productsList;
    List<Flow> flowList;
    List<FlowSteps> flowStepsList;
    List<List<String>> list = new ArrayList<>();

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    FlowStepsRepository flowStepsRepository;

    @Autowired
    FlowRepository flowRepository;

    @Autowired
    ActivityRepository activityRepository;

    public String setData(DTO dto)
    {

        if(!productsRepository.existsById(dto.getProducts().getProductId()))
        {
            return "Invalid productId";
        }
        else
        {
            System.out.println("Given productId exists");
        }
        if(!flowRepository.existsById(dto.getFlow().getFlowId()))
        {
            return "Invalid flowId";
        }
        else
        {
            System.out.println("Given flowId exists");
        }

        productsList = productsRepository.findProductDeatilsUsingId(dto.getProducts().getProductId());
        flowList = flowRepository.findFlowDetailsUsingFlowId(dto.getFlow().getFlowId());
        flowStepsList = flowStepsRepository.findFlowStepsDetailsUsingFlowId(dto.getFlow().getFlowId());

        dto.getProducts().setProductName(productsList.get(0).getProductName());

        dto.getFlow().setFlowDescription(flowList.get(0).getFlowDescription());
        dto.getFlow().setTotalSteps(flowList.get(0).getTotalSteps());

        if(dto.getFlow().getTotalSteps() < dto.getActivity().getStepsCompleted())
        {
            return "Invalid stepsCompleted";
        }

        else if(dto.getFlow().getTotalSteps() == dto.getActivity().getStepsCompleted())
        {
            return "Successful completion";
        }

        else
        {
            for (FlowSteps flowSteps : flowStepsList) {
                List<String> temp = new ArrayList<>();
                temp.add(flowSteps.getStepDescription());
                temp.add(Integer.toString(flowSteps.getStepNo()));
                list.add(temp);
            }
            return "True";
        }
    }

    public void printMessage(DTO dto, String message)
    {

        switch(message)
        {
            case "Invalid productId" :
                System.out.println("INVALID INPUT : Given productId does not exist"); break;

            case "Invalid flowId" :
                System.out.println("INVALID INPUT : Given flowId does not exist"); break;

            case "Invalid stepsCompleted" :
                System.out.println("INVALID INPUT : Given stepsCompleted exceeds the totalSteps of the flow " + dto.getFlow().getFlowDescription() + " of the product " + dto.getProducts().getProductName() + " for the user " + dto.getActivity().getMailId());
                break;

            case "Successful completion" :
                dto.getActivity().setCreatedAt();
                dto.getActivity().setUpdatedAt();
                dto.getActivity().setActivityStatus("Completed");
                activityRepository.save(dto.getActivity());
                System.out.println("ACTIVITY STATUS : " + dto.getActivity().getActivityStatus());
                System.out.println("Message : " + dto.getActivity().getMailId() + " has successfully completed the " + dto.getFlow().getFlowDescription() + " for the product : " + dto.getProducts().getProductName());
                break;

            case "True" :
                dto.getActivity().setCreatedAt();
                dto.getActivity().setUpdatedAt();
                dto.getActivity().setActivityStatus("In progress");
                activityRepository.save(dto.getActivity());
                System.out.println("ACTIVITY STATUS : " + dto.getActivity().getActivityStatus());
                System.out.println("Message : " + dto.getActivity().getMailId() + " has not completed the " + dto.getFlow().getFlowDescription() + " for the product : " + dto.getProducts().getProductName());

                System.out.println("--------STEP COMPLETED--------");
                for(int i = 0; i<dto.getActivity().getStepsCompleted(); i++)
                {
                    System.out.println("STEP DESCRIPTION : " + list.get(i).get(0));
                    System.out.println("STEP NUMBER      : " + list.get(i).get(1));
                }

                System.out.println("-----STEP TO BE COMPLETED-----");
                for(int i = dto.getActivity().getStepsCompleted(); i < list.size(); i++)
                {
                    System.out.println("STEP DESCRIPTION : " + list.get(i).get(0));
                    System.out.println("STEP NUMBER      : " + list.get(i).get(1));
                }
        }
    }
}
