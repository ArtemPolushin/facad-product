package org.example.Facad.Student;
import java.util.List;


public class StudentHandler {
    private Database database;

    public StudentHandler(Database database) {
        this.database = database;
    }

    // Метод для обработки запроса POST /student
    public int createStudent(String name, String surname, String secondName, String course) {
        // Логика создания студента
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setSecondName(secondName);
        student.setCourse(course);

        // Сохранение студента в базу данных
        int id = database.saveStudent(student);
        return id;
    }

    // Метод для обработки запроса GET /students
    public List<Student> getAllStudents() {
        // Логика получения всех студентов из базы данных
        return database.getAllStudents();
    }
}
