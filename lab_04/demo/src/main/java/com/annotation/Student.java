package com.annotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private int age;
    private List<Subject> subjects;
    private Address address;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age, Address address, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subjects = subjects;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void getDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }

    public void setAddress(Address addr) {
        this.address = addr;
    }

    public Address getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}