package org.example;
import org.example.Facad.Student.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExtendedApiFacade facade = new ExtendedApiFacade();

        // Создание нового студента
        int newStudentId = facade.createStudent("John", "Doe", "Smith", "101");
        System.out.println("Created new student with ID: " + newStudentId);

        // Получение списка всех студентов
        List<Student> students = facade.getAllStudents();
        System.out.println("All students: ");
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getSurname());
        }
    }
}