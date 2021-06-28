package com.rj.service;

import com.rj.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Slf4j
public class StudentService {
    @Autowired
    MQService mqService;
    @Value("${activemq.destination}")
    private String destination;
    public String sendMessage(Student student) {
        mqService.sendTo(destination, student);
        return "success";
    }
}
