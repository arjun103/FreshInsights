package com.example.freshinsights.service;

import com.example.freshinsights.model.Employee;
import com.example.freshinsights.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder ;

    public void createEmployee(Employee employee)
    {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setCreatedAt();
        employee.setUpdatedAt();
        employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees()
    {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee findEmployeeByID(BigInteger id)
    {
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployee(BigInteger id)
    {
        employeeRepository.deleteById(id);
    }
}
