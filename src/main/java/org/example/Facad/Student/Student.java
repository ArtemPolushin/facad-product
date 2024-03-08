package org.example.Facad.Student;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String secondName;
    private String course;

    public Student() {
    }

    public Student(int id, String name, String surname, String secondName, String course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.course = course;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getCourse() {
        return course;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
