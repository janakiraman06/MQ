package com.rj.service;

import com.rj.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmployeeService {
    @Autowired
    MQService mqService;
    @Autowired
    JmsTemplate jmsTemplate;
    @Value("${active-mq.topic}")
    private String topicDestination;
    public void sendMessage(Employee employee) {
        System.out.println("ServiceLayer jmstemplate hashcode is " + jmsTemplate.hashCode());
        mqService.sendMessage(employee, topicDestination);
    }
}
