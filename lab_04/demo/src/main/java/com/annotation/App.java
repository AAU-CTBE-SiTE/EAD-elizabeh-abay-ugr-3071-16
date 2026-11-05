package com.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize Spring ApplicationContext with XML config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student = context.getBean("student", Student.class);
        student.setId(101);
        student.setName("John");
        student.setAge(34);
        student.getDetails();

        System.out.println("Setter based Injection method");
        Student studentTwo = context.getBean("student", Student.class);

        // Concatenated String using '+' instead of invalid ',' argument
        System.out.println("Student Name : " + studentTwo.getName());
        System.out.println(studentTwo);
        studentTwo.getDetails();

        System.out.println("Constructor based injections");
        Student studentThree = context.getBean("student", Student.class);
        System.out.println(studentThree);

        // Replaced shorthand 'CPXAC' with ClassPathXmlApplicationContext
        ApplicationContext contextTwo = new AnnotationConfigApplicationContext(AppConfig.class);

        Student studentFour = contextTwo.getBean("student", Student.class);
        System.out.println(studentFour);
        System.out.println(studentFour.getName());

        System.out.println("Object Dependency injection");
        Student studentFive = contextTwo.getBean("student", Student.class);
        System.out.println(studentFive);

        Student studentSix = contextTwo.getBean("student", Student.class);
        System.out.println(studentSix);

        Student studentSeven = contextTwo.getBean("student", Student.class);
        System.out.println(studentSeven);
        studentSeven.getDetails();
    }
}
