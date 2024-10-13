package org.example.lesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        System.out.println("lesson 3 HW - 1");

        List<Student> studentList = getStudentList();

        studentList.stream()
            .filter(student -> Objects.equals(student.getAddress().getCity(), "New York") && student.getAge() > 15)
            .flatMap(student -> student.getGrades()
                    .stream()
                    .map(grad -> new StudentGradeRecord(student.getName(), student.getSchool(), grad.getSubject(), grad.getScore()))
            )
            .sorted(Comparator.comparing(StudentGradeRecord::getScore).reversed())
            .limit(3)
            .forEach(System.out::println);
    }

    private static List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();

        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade("Math", 95.0));
        grades.add(new Grade("Science", 92.0));
        studentList.add(new Student("Charlie", 15, grades, "High School A", new Address("New York", "12")));

        grades = new ArrayList<>();
        grades.add(new Grade("Math", 88.0));
        grades.add(new Grade("Science", 78.9));
        studentList.add(new Student("Alice", 17, grades, "High School A", new Address("City 1", "2")));

        grades = new ArrayList<>();
        grades.add(new Grade("Math", 85.5));
        grades.add(new Grade("Science", 70.00));
        studentList.add(new Student("David", 16, grades, "High School C", new Address("New York", "3")));

        grades = new ArrayList<>();
        grades.add(new Grade("Math", 85.0));
        studentList.add(new Student("Mat", 12, grades, "Middle School A", new Address("New York", "1")));

        grades = new ArrayList<>();
        grades.add(new Grade("Science", 99.0));
        studentList.add(new Student("Jessika", 17, grades, "Middle School B", new Address("New York", "5")));

        grades = new ArrayList<>();
        grades.add(new Grade("Science", 97.8));
        studentList.add(new Student("Marta", 17, grades, "Middle School C", new Address("New York", "5")));

        return studentList;
    }
}
