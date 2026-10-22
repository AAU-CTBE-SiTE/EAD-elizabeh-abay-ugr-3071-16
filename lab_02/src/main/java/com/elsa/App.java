package com.elsa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {

    // this means create the entityManagerFactory in the class level
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void createStudent(Student student) {
        // when u are given a student obj this is the actual method to make it
        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(student);
        // create and then persist it and commit

        entityManager.getTransaction().commit();
    }

    public static Student getStudentById(int id) {
        EntityManager entityManager = getEntityManager();

        return entityManager.find(Student.class, id);
    }

    public static void updateStudentNameGivenId(String newName, int id) {
        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();

        Student studentFound = getStudentById(id);

        studentFound.setName(newName);

        entityManager.getTransaction().commit();
    }

    public static void deleteStudentById(int id) {
        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();
        Student studentToBeDeleted = getStudentById(id);

        entityManager.remove(studentToBeDeleted);
        entityManager.getTransaction().commit();
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Mohammed Ali");
        student.setTech("Python");
        student.setId(2);

        // this method will be responsible for closing and openning
        // the transaction
        createStudent(student);
        Student mohammed = getStudentById(2);
        System.out.print(mohammed);

        updateStudentNameGivenId("Abebe", 2);
        deleteStudentById(2);

    }
}