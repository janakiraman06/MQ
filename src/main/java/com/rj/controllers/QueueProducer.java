package com.rj.controllers;

import com.rj.service.MQService;
import com.rj.model.Student;
import com.rj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueProducer {

    @Autowired
    StudentService studentService;



    @PostMapping("/")
    public String sendMessage(@RequestBody Student student) {
        studentService.sendMessage(student);
        return "success";
    }

}
