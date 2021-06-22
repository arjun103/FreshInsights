package com.example.freshinsights.repository;

import com.example.freshinsights.model.Flow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface FlowRepository extends CrudRepository<Flow, BigInteger>
{

    @Query(value = "SELECT * FROM FlowTable WHERE flowId = ?", nativeQuery = true)
    List<Flow> findFlowDetailsUsingFlowId(BigInteger flowId);
}
