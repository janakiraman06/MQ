package com.rj.controllers;

import com.rj.model.Employee;
import com.rj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicPublisher {

    @Autowired
    EmployeeService employeeService;
    @PostMapping(value = "/api/employee")
    public Employee sendMessage(@RequestBody Employee employee){
        employeeService.sendMessage(employee);
        return employee;
    }
}
