package com.kuebiko.springwebapp.DAO_dataAccessObject_repository;

import com.kuebiko.springwebapp.DTO_dataTransferObject_entity.StudentDTO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImport {

    @Autowired
    private SessionFactory sessionFactory;

    public void addStudent(StudentDTO studentDTO){
        sessionFactory.getCurrentSession().saveOrUpdate(studentDTO);
    }
}
