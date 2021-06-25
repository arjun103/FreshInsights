package com.example.freshinsights.service;

import com.example.freshinsights.model.Activity;
import com.example.freshinsights.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;

@Service
public class ActivityService
{
    @Autowired
    ActivityRepository activityRepository;

    public void deleteActivity(BigInteger id)
    {
        activityRepository.deleteById(id);
    }

    public List<Activity> findAllActivities()
    {
        return (List<Activity>) activityRepository.findAll();
    }

    public Activity findActivityByID(BigInteger id)
    {
        return activityRepository.findById(id).get();
    }

    public List<Activity> findAllActivitiesByStatus(String status)
    {
        for(Activity activity : activityRepository.findAllActivitiesByStatus(status)){
            System.out.println(activity.toString());
        }
        return activityRepository.findAllActivitiesByStatus(status);
    }
}
