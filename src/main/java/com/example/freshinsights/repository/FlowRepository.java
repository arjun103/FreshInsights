package com.example.freshinsights.repository;

import com.example.freshinsights.model.Flow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;

@Repository
public interface FlowRepository extends CrudRepository<Flow, BigInteger>
{
    @Query(value = "SELECT * FROM FlowTable f, FlowStepsTable fs where f.flowId = fs.flowId and f.productId = ? and fs.stepdescription = ?", nativeQuery = true)
    Flow findFlowDetailsUsingCustomDetails(BigInteger productId, String stepDescription);
}
