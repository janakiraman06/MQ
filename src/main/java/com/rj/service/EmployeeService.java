package com.rj.service;

import com.rj.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmployeeService {
    @Autowired
    MQService mqService;
    @Value("${active-mq.topic}")
    private String topicDestination;
    public void sendMessage(Employee employee) {
        mqService.sendMessage(employee, topicDestination);
    }
}
