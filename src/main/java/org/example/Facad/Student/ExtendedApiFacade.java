package org.example.Facad.Student;
import java.util.List;

public class ExtendedApiFacade{
    private StudentHandler studentHandler;
    private Database database;

    public ExtendedApiFacade() {
        super();
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
