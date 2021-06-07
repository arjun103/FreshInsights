package com.example.freshinsights.repository;

import com.example.freshinsights.model.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, BigInteger>
{

}