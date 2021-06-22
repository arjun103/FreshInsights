package com.example.freshinsights.repository;

import com.example.freshinsights.model.FlowSteps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface FlowStepsRepository extends JpaRepository<FlowSteps, BigInteger>
{
    @Query(value = "SELECT * FROM FlowStepsTable WHERE flowId = ?", nativeQuery = true)
    List<FlowSteps> findFlowStepsDetailsUsingFlowId(BigInteger flowId);
}
