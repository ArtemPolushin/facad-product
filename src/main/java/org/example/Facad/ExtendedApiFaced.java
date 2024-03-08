package org.example.Facad;

import org.example.Facad.Student.Database;
import org.example.Facad.Student.Student;
import org.example.Facad.Student.StudentHandler;

import java.util.List;

public class ExtendedApiFaced {
    private StudentHandler studentHandler;
    private Database database;

    public ExtendedApiFaced() {
        this.database = new Database();
        this.studentHandler = new StudentHandler(database);
    }

    // Методы фасада для работы с студентами
    public int createStudent(String name, String surname, String secondName, String course) {
        return studentHandler.createStudent(name, surname, secondName, course);
    }

    public List<Student> getAllStudents() {
        return studentHandler.getAllStudents();
    }
}
