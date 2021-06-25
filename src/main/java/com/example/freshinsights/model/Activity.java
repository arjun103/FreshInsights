package com.example.freshinsights.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public Activity() {
    }

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

    public void setActivityStatus(String activityStatus)
    {
        this.activityStatus = activityStatus;
    }

    @Override
    public String toString() {
        return "Activity{" +
                ", productId=" + productId +
                ", flowId=" + flowId +
                ", mailId='" + mailId + '\'' +
                ", activityStatus='" + activityStatus + '\'' +
                ", stepsCompleted=" + stepsCompleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
