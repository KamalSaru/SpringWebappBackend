package com.kuebiko.springwebapp.service;

import com.kuebiko.springwebapp.DAO_dataAccessObject_repository.StudentDAOImport;
import com.kuebiko.springwebapp.DTO_dataTransferObject_entity.StudentDTO;
import com.kuebiko.springwebapp.model.AddStudentRequest;
import com.kuebiko.springwebapp.model.Students;
import com.kuebiko.springwebapp.model.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDAOImport studentDAOImport;

    //@Postmapping--student inserted for RequestParam--------------------------------------------
    public void addStudent(String studentID, String firstName, String lastName, Long phoneNumber, String email,
                               String address, String gender, String status){
        StudentDTO studentDTO=new StudentDTO();
        studentDTO.setStudentID(studentID);
        studentDTO.setFirstName(firstName);
        studentDTO.setLastName(lastName);
        studentDTO.setPhoneNumber(phoneNumber);
        studentDTO.setEmail(email);
        studentDTO.setAddress(address);
        studentDTO.setGender(gender);
        studentDTO.setStatus(status);
        studentDAOImport.addStudent(studentDTO);
        }

    //@PostMapping---student inserted1 for Requestbody----------------------------------------------
    public void addStudent(AddStudentRequest addStudentRequest){
        StudentDTO studentDTO=new StudentDTO();
        studentDTO.getStudentID();
        studentDTO.setFirstName(addStudentRequest.getFirstName());
        studentDTO.setLastName(addStudentRequest.getLastName());
        studentDTO.setPhoneNumber(addStudentRequest.getPhoneNumber());
        studentDTO.setEmail(addStudentRequest.getEmail());
        studentDTO.setAddress(addStudentRequest.getAddress());
        studentDTO.setGender(addStudentRequest.getGender());
        studentDTO.setStatus(addStudentRequest.getStatus());
        studentDAOImport.addStudent(studentDTO);
    }


    //@Getmapping----------getting all the students list
    public List<Students> listAllStudents() {
        List<StudentDTO> studentsDTOS = studentDAOImport.listAllStudents();

        List<Students> students1 = new ArrayList<>();
        for (StudentDTO studentDTO : studentsDTOS) {
            Students students = new Students();
            students.setStudentID(studentDTO.getStudentID());
            students.setFirstName(studentDTO.getFirstName());
            students.setLastName(studentDTO.getLastName());
            students.setPhoneNumber(studentDTO.getPhoneNumber());
            students.setEmail(studentDTO.getEmail());
            students.setAddress(studentDTO.getAddress());
            students.setGender(studentDTO.getGender());
            students.setStatus(studentDTO.getStatus());
            students1.add(students);
           }
             return students1;
        }

    //@PutMapping--
    //http://localhost:8080/students/action/update
    //To access the DAO and find ID for update---findStudentID class
        public void updateStudent(UpdateStudentRequest updateStudentRequest) {
        StudentDTO studentDTO = studentDAOImport.findByStudentID(updateStudentRequest.getStudentID());
        //Any name or field?------to set and get???
        studentDTO.setFirstName(updateStudentRequest.getFirstName());
        studentDAOImport.updateStudent(studentDTO);
        }


    //Deletemapping--------
    //http://localhost:8080/students/action/delete
    public void deleteStudent(String studentID) {
        StudentDTO studentDTO = studentDAOImport.findByStudentID(studentID);
        studentDAOImport.deleteStudent(studentDTO);
    }
}
