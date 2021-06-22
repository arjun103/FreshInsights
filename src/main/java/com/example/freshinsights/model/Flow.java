package com.example.freshinsights.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "FlowTable")
public class Flow
{

    @Id
    @Column(name = "flowId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger flowId;

    @Column(name = "flowDescription")
    String flowDescription;

    @Column(name = "totalSteps")
    int totalSteps;

    @Column(name = "productId")
    BigInteger productId;

    @Override
    public String toString() {
        return "Flow{" +
                "flowId=" + flowId +
                ", flowDescription='" + flowDescription + '\'' +
                ", totalSteps=" + totalSteps +
                ", productId=" + productId +
                '}';
    }
}
