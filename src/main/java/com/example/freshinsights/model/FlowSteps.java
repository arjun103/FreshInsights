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
    int id;

    @Column(name = "flowId")
    BigInteger flowId;

    @Column(name = "stepDescription")
    String stepDescription;

    @Column(name = "stepNo")
    int stepNo;
}
