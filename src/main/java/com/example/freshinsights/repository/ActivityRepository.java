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

    @Query(value = "SELECT * FROM ActivityTable WHERE productId = ? and flowId = ? and stepsCompleted = ?", nativeQuery = true)
    Activity findActivityDetailsByCustom(BigInteger productId, BigInteger flowId, int stepsCompleted);
}