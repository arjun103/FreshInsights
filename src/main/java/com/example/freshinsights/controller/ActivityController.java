package com.example.freshinsights.controller;

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

    @PostMapping("/activity")
    void createactivity(@RequestBody Activity activity){
        activityService.createActivity(activity);}

    @GetMapping("/activity")
    List<Activity> findAllActivities()
    {
        return activityService.findAllActivities();
    }

    @GetMapping("/activity/{id}")
    Activity findActivityByID(@PathVariable BigInteger id)
    {
        return activityService.findActivityByID(id);
    }

    @DeleteMapping("/activity/{id}")
    void deleteActivity(@PathVariable  BigInteger id)
    {
        activityService.deleteActivity(id);
    }
}
