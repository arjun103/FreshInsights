package com.example.freshinsights.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "FlowStepsTable")
public class FlowSteps
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;

    @Column(name = "flowId")
    BigInteger flowId;

    @Column(name = "stepDescription")
    String stepDescription;

    @Column(name = "stepNo")
    int stepNo;

    @Override
    public String toString()
    {
        return "FlowSteps{" +
                "flowId=" + flowId +
                ", stepDescription='" + stepDescription + '\'' +
                ", stepNo=" + stepNo +
                '}';
    }
}
