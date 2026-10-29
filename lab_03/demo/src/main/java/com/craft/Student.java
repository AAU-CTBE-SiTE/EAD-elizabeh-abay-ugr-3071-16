package com.craft;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Student {
    private String name;
    String tech;
    @Id
    private int id;
    private int age;

    // private String city;
    // private String country;
    private Address address;

    private List<Subject> subjects;

    Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

        System.out.println("Student Parameterized Constructor Called");
    }

    public Student(int id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;

        System.out.println("Student Parameterized Constructor with Address Called");
    }

    // spring will call the set properties for setting props

    public void setName(String name) {
        this.name = name;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getDetails() {
        System.out.println("Student Name " + this.getName());

        int index = 1;
        for (Subject subject : subjects) {
            System.out.println("Subject " + index + ": " +
                    subject.getSubjectName());
            index++;
        }
    }

}
