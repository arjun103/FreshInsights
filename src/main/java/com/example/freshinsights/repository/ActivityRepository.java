package com.example.freshinsights.repository;

import com.example.freshinsights.model.Activity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, BigInteger>
{
    @Query(value = "SELECT * FROM ActivityTable WHERE  activityStatus = ?", nativeQuery = true)
    List<Activity> findAllActivitiesByStatus(String status);

    @Query(value = "SELECT * FROM ActivityTable WHERE productId = ? and flowId = ? and stepsCompleted = ? and mailId = ?", nativeQuery = true)
    Activity findActivityDetailsByCustom(BigInteger productId, BigInteger flowId, int stepsCompleted, String mailId);

    @Query(value = "SELECT * FROM ActivityTable WHERE productId = ? and flowId = ? and mailId = ? and  activityStatus = ?", nativeQuery = true)
    List<Activity> findActivityDetailsByCustom(BigInteger productId, BigInteger flowId, String mailId, String activityStatus);
}