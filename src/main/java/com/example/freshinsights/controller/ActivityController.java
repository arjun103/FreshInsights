package com.example.freshinsights.controller;

import com.example.freshinsights.ActivityStatus;
import com.example.freshinsights.model.Activity;
import com.example.freshinsights.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/freshinsights")
public class ActivityController
{
    @Autowired
    ActivityService activityService;

    @GetMapping("/activities")
    List<Activity> findAllActivities()
    {
        return activityService.findAllActivities();
    }

    @GetMapping("/activity/{id}")
    Activity findActivityByID(@PathVariable BigInteger id)
    {
        return activityService.findActivityByID(id);
    }

    @DeleteMapping("/activity/{id}/delete")
    void deleteActivity(@PathVariable  BigInteger id)
    {
        activityService.deleteActivity(id);
    }

    @GetMapping("/activities/inprogress")
    List<Activity> findAllInProgressActivities()
    {
        return activityService.findAllActivitiesByStatus(ActivityStatus.IN_PROGRESS.name());
    }

    @GetMapping("/activities/completed")
    List<Activity> findAllCompletedActivities()
    {
        return activityService.findAllActivitiesByStatus(ActivityStatus.COMPLETED.name());
    }
}
