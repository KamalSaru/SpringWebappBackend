package com.kuebiko.springwebapp.controller;

import com.kuebiko.springwebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController//used to create REST ful web services using Spring MVC, Mapping request data
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value ="/students/action/insert")
    //http://localhost:8080/students/action/insert
    public ResponseEntity<?>addStudent(
            @RequestParam Long studentID,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Long phoneNumber,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam LocalDate dob,
            @RequestParam Integer age,
            @RequestParam String gender,
            @RequestParam String accountStatus){
        studentService.addStudent(studentID,firstName,lastName,phoneNumber, email,address, dob,age,gender,accountStatus);
        return new ResponseEntity<>("New student successfully inserted.", HttpStatus.OK);
    }

}
