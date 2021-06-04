package com.example.freshinsights.service;

import com.example.freshinsights.model.Employee;
import com.example.freshinsights.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee)
    {
        employee.setCreatedAt();
        employee.setUpdatedAt();
        employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees()
    {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee findEmployeeByID(int id)
    {
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployee(int id)
    {
        employeeRepository.deleteById(id);
    }
}
