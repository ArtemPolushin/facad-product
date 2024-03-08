package org.example.Facad.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dmitriy";
    private static final String USER = "dmitriy";
    private static final String PASSWORD = "1234";

    // Метод для сохранения студента в базе данных
    public int saveStudent(Student student) {
        String sql = "INSERT INTO students (name, surname, second_name, course) VALUES (?, ?, ?, ?) RETURNING id";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getSecondName());
            statement.setString(4, student.getCourse());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                return -1; // В случае ошибки при сохранении возвращаем -1
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при сохранении студента в базу данных:");
            e.printStackTrace();
            return -1;
        }
    }

    // Метод для получения списка всех студентов из базы данных
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setSecondName(resultSet.getString("second_name"));
                student.setCourse(resultSet.getString("course"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении списка студентов из базы данных:");
            e.printStackTrace();
        }
        return students;
    }
}
