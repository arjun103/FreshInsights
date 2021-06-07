package com.example.freshinsights.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ActivityTable")
public class Activity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;

    @Column(name = "productId")
    BigInteger productId;

    @Column(name = "flowId")
    BigInteger flowId;

    @Column(name = "mailId")
    String mailId;

    @Column(name = "activityStatus")
    String activityStatus;

    @Column(name = "stepsCompleted")
    int stepsCompleted;

    @Column(name = "createdAt")
    LocalDateTime createdAt;

    @Column(name = "updatedAt")
    LocalDateTime updatedAt;

    public void setCreatedAt()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        createdAt = LocalDateTime.now();
        dtf.format(createdAt);
    }

    public void setUpdatedAt()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        updatedAt = LocalDateTime.now();
        dtf.format(updatedAt);
    }

    public void setActivityStatus() {
        activityStatus = "waiting for review";
    }

    public void setStepsCompleted() {
        stepsCompleted = 0;
    }
}
