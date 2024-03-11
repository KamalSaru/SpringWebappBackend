package com.kuebiko.springwebapp.DTO_dataTransferObject_entity;


import com.fasterxml.jackson.annotation.JsonFormat;

//import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="students")
public class StudentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ID;
    @Column(name = "student_ID")
    private Long studentID;

    @Column(name = "first_name")
    private String firstName;
    private String lastName;

    @JsonFormat(pattern="000-000-0000")
    private Long phoneNumber;

    //@NotBlank(message = "Please, provide email address.")
    @Column(name = "email_address")
    private String email;

    @Column(name = "home_address")
    private String address;

    @Column(name="date_of_birth")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dob;

    @Transient//Age calculation
    //@Temporal(TemporalType.TIMESTAMP)
    //When getMapping we can see the age in year(2023-2000=23)-----------------
    private Integer age;
    public Integer getAge() {
        if (dob != null) {
            return Period.between(dob, LocalDate.now()).getYears();
        }
        return null;
    }
    private String gender;
    @Column(name = "account_status")
    private String accountStatus;


    //Generate-----Getter and Setter---------------------------------------------
    public Long getID() {
        return ID;
    }
    public void setID(Long ID) {
        this.ID = ID;
    }
    public Long getStudentID() {
        return studentID;
    }
    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

}


