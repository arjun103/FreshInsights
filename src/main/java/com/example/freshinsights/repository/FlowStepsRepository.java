package com.example.freshinsights.repository;

import com.example.freshinsights.model.FlowSteps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowStepsRepository extends CrudRepository<FlowSteps, Integer>
{

}
