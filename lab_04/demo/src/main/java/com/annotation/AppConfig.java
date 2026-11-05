package com.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.beans.BeanProperty;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        Address address = new Address();
        address.setCity("Addis");
        address.setStreet("Ethiopia");
        return address;
    }

    @Bean
    public Subject math() {
        Subject subject = new Subject();
        subject.setSubjectName("Maths 101");
        return subject;
    }

    @Bean(name = "Java")
    public Subject javaSubject() {
        Subject subject = new Subject();
        subject.setSubjectName("Java EE");
        return subject;
    }

    @Bean
    @Scope("prototype")
    public Student student() {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(20);
        student.setId(101);
        student.setAddress(address());
        student.setSubjects(Arrays.asList(math(), javaSubject()));
        return student;
    }

    @Bean(name = "student_constructor")
    @Scope("prototype")
    public com.annotation.Student studentConstructor() {
        return new com.annotation.Student(
                101,
                "John Doe",
                20,
                address(),
                Arrays.asList(math(), javaSubject()));
    }
}
