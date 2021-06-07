package com.example.freshinsights.repository;

import com.example.freshinsights.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, BigInteger>
{

}
