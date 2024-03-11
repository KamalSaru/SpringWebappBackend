package com.kuebiko.springwebapp.service;

import com.kuebiko.springwebapp.DAO_dataAccessObject_repository.StudentDAOImport;
import com.kuebiko.springwebapp.DTO_dataTransferObject_entity.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentService {

        @Autowired
        private StudentDAOImport studentDAOImport;

        public void addStudent(Long studentID, String firstName, String lastName, Long phoneNumber, String email,
                               String address, LocalDate dob, Integer age, String gender,  String accountStatus){
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setStudentID(studentID);
            studentDTO.setFirstName(firstName);
            studentDTO.setLastName(lastName);
            studentDTO.setPhoneNumber(phoneNumber);
            studentDTO.setEmail(email);
            studentDTO.setAddress(address);
            studentDTO.setDob(dob);
            studentDTO.setAge(age);
            studentDTO.setGender(gender);
            studentDTO.setAccountStatus(accountStatus);

            studentDAOImport.addStudent(studentDTO);
        }

}
