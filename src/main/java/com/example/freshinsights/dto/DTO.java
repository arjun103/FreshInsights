package com.example.freshinsights.dto;

import com.example.freshinsights.model.Activity;
import com.example.freshinsights.model.Flow;
import com.example.freshinsights.model.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTO {
    Activity activity;
    Flow flow;
    Products products;

    public DTO(Activity activity, Flow flow, Products products) {
        this.activity = activity;
        this.flow = flow;
        this.products = products;
    }

    public void setIds(){
        products.setProductId(activity.getProductId());
        flow.setFlowId(activity.getFlowId());

    }
}
