package com.example.freshinsights.repository;

import com.example.freshinsights.model.FlowSteps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FlowStepsRepository extends CrudRepository<FlowSteps, BigInteger>
{

}
