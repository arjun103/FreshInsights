package com.example.freshinsights.service;

import com.example.freshinsights.model.Activity;
import com.example.freshinsights.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService
{
    @Autowired
    ActivityRepository activityRepository;

    public void createActivity(Activity activity)
    {
        activity.setCreatedAt();
        activity.setUpdatedAt();
        activityRepository.save(activity);
    }

    public void deleteActivity(int id) {
        activityRepository.deleteById(id);
    }

    public List<Activity> findAllActivities() {return (List<Activity>) activityRepository.findAll();
    }

    public Activity findActivityByID(int id) {return activityRepository.findById(id).get();
    }
}
