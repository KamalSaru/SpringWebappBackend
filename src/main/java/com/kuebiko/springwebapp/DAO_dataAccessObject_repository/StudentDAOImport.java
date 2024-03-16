package com.kuebiko.springwebapp.DAO_dataAccessObject_repository;

import com.kuebiko.springwebapp.DTO_dataTransferObject_entity.StudentDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentDAOImport {

    @Autowired
    private SessionFactory sessionFactory;

    //@Postmapping--student inserted
    public void addStudent(StudentDTO studentDTO) {
        sessionFactory.getCurrentSession().saveOrUpdate(studentDTO);
    }


    //@Getmapping----get student details
    public List<StudentDTO> listAllStudents() {
        return sessionFactory.getCurrentSession().createQuery("FROM StudentDTO ").getResultList();
    }


    //@Putmapping--update all the existing student using ID-----
    //http://localhost:8080/students/action/update
    public void updateStudent(StudentDTO studentDTO) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(studentDTO);
        transaction.commit();
        session.close();
    }

    //Putmapping--------------------ExtendRepository
    //To access the DAO and find ID for update---findStudentID class
    //http://localhost:8080/students/action/update
    public StudentDTO findByStudentID(String studentID) {
        List<StudentDTO> studentDTOS
                = sessionFactory.getCurrentSession().createQuery("FROM StudentDTO where studentID ='" +
                studentID + "'").getResultList();
        return studentDTOS.get(0);
    }


    //Deletemapping----
    public void deleteStudent(StudentDTO studentDTO) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.delete(studentDTO);
        //session.saveOrUpdate(studentDTO); //This code delete first and save again-------
        transaction.commit();
        session.close();
    }
}
