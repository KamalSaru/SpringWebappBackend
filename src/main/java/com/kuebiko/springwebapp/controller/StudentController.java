package com.kuebiko.springwebapp.controller;

import com.kuebiko.springwebapp.model.AddStudentRequest;
import com.kuebiko.springwebapp.model.UpdateStudentRequest;
import com.kuebiko.springwebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//used to create REST ful web services using Spring MVC, Mapping request data
public class StudentController {

    @Value("Student insert successfully.")
    private String successfulMessage;

    @Autowired
    private StudentService studentService;

    @PostMapping(value ="/students/action/insert")
    //Postman------postmapping using the Request param----------
    //In Postman ------------http://localhost:8080/students/action/insert
    public ResponseEntity<?> addStudent(
            @RequestParam String studentID,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Long phoneNumber,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam String gender,
            @RequestParam String status){
        studentService.addStudent(studentID,firstName,lastName,phoneNumber, email,address,gender, status);
        return new ResponseEntity<>("New student successfully inserted.", HttpStatus.OK);
    }

    @PostMapping(value = "/students/action/insert1")
    //Postman----postmapping using the Requestbody----------
    ////In Postman ----http://localhost:8080/students/action/insert1
    public ResponseEntity<?> addStudent1(@RequestBody AddStudentRequest addStudentRequest) {
        studentService.addStudent(addStudentRequest);
        return new ResponseEntity<>(successfulMessage, HttpStatus.OK);
    }


    @GetMapping(value = "/students/action/list-all")
    //Getting all list of students details------------------
    //In Postman--http://localhost:8080/students/action/list-all
    public ResponseEntity<?> listAllStudents() {
        return new ResponseEntity<>(studentService.listAllStudents(), HttpStatus.OK);
    }

    @PutMapping(value = "/students/action/update")
    //http://localhost:8080/students/action/update
    public ResponseEntity<?> updateStudent(@RequestBody UpdateStudentRequest updateStudentRequest){
        studentService.updateStudent(updateStudentRequest);
        return new ResponseEntity<>("Student update successfully.", HttpStatus.OK);
    }

    @DeleteMapping(value = "/students/action/delete")
    //Delete using the Param in Postman
    //http://localhost:8080/students/action/delete
    public ResponseEntity<?> deleteStudent(@RequestParam String studentID) {
        studentService.deleteStudent(studentID);
        return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
    }
}
