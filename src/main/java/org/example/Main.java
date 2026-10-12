package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
// importing things


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");

        String connectionString = "jdbc:mysql://localhost:3306/lab_01";
        String username = "root";
        String password = "Hello";

        String createTable = "CREATE TABLE studentss (id int PRIMARY KEY,   name VARCHAR(100));";
        String insertData = "Insert into student (id , name) values (? , ?)";
        String selectingData = "select * from student";


        try {
            Connection connected = DriverManager.getConnection(connectionString , username , password);
            System.out.print("Successful Connection");

            Statement createStatement = connected.createStatement();
            createStatement.execute(createTable);


            PreparedStatement insertStatement = connected.prepareStatement(insertData);
            insertStatement.setString(1, java.util.UUID.randomUUID().toString());
            insertStatement.setString(2 , "elizabeth");
            insertStatement.execute();

            var Returned = createStatement.executeQuery(selectingData);
            System.out.print(Returned.getClass());



        } catch (Exception err){
            System.out.print("\n Error happened");
            System.out.print(err.getMessage());

        }




    }
}