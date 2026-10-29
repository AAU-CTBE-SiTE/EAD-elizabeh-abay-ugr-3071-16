package com.craft;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // System.out.println("Hello World!");

        // ApplicationContext extends BeanFactory and getBean
        ApplicationContext context = new ClassPathApplicationContext("beansConfig.xml");

        Student student = context.getBean("student", Student.class);

        student.setId(101);
        student.setName("John");
        student.setAge(34);

        student.getDetails();

        System.out.println("Setter based Injection method");

        Student studentTwo = context.getBean("student", Student.class);

        System.out.println("Student Name : ", studentTwo.getName());
        System.out.println(studentTwo);

        studentTwo.getDetails();

        System.out.println("Constructor based injections");

        Student studentThree = context.getBean("student", Student.class);

        System.out.println(studentThree);

        ApplicationContext contextTwo = new CPXAC("beanConfig.xml");

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
