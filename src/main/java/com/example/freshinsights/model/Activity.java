package com.example.freshinsights.model;

import com.example.freshinsights.repository.FlowStepsRepository;
import com.example.freshinsights.service.ActivityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Activity{");
        sb.append("productId='").append(productId).append('\'');
        sb.append(", flowId='").append(flowId).append('\'');
        sb.append(", mailId='").append(mailId).append('\'');
        sb.append(", activityStatus='").append(activityStatus).append('\'');
        sb.append(", stepsCompleted='").append(stepsCompleted).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
