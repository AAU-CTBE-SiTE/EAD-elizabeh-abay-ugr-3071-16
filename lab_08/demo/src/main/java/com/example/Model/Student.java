package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String Email;

    @Column(name = "firstname")
    private String FirstName;

    @Column(name = "lastname")
    private String LastName;

    @Column(name = "department")
    private String Department;

    // 1. JPA requires a public or protected no-argument constructor
    public Student() {
    }

    public Student(Integer id, String email, String FirstName, String LastName, String Depatment) {
        this.id = id;
        this.Email = email;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Department = Depatment;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getDepartement() {
        return Department;
    }

    public void setFirstName(String newName) {
        FirstName = newName;
    }

    public void setLastName(String newName) {
        LastName = newName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setDepartment(String departement) {
        Department = departement;
    }

}