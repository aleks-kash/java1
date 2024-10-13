package org.example.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<Grade> grades;
    private String school;
    private Address address;

    public Student(String name, int age, List<Grade> grades, String school, Address address) {
        this.name = name;
        this.age = age;
        this.grades = grades;
        this.school = school;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grades=" + grades +
                ", school='" + school + '\'' +
                ", address=" + address +
                '}';
    }
}
