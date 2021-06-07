package com.example.freshinsights.repository;

import com.example.freshinsights.model.Flow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FlowRepository extends CrudRepository<Flow, BigInteger>
{

}
