package com.example.freshinsights.controller;

import com.example.freshinsights.model.*;
import com.example.freshinsights.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/freshinsights")
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;


    @PostMapping("/employee")
    void createEmployee(@RequestBody Employee employee){employeeService.createEmployee(employee);}


    @GetMapping("/employees")
    List<Employee> findAllEmployees()
    {
        return employeeService.findAllEmployees();
    }


    @GetMapping("/employee/{id}")
    Employee findEmployeeByID(@PathVariable BigInteger id)
    {
        return employeeService.findEmployeeByID(id);
    }


    @DeleteMapping("/employee/{id}/delete")
    void deleteEmployee(@PathVariable  BigInteger id)
    {
        employeeService.deleteEmployee(id);
    }
}
