package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students;
    private String name;
    private int age;


    public University(String name, int age) {
        this.name = name;
        this.age = age;
        this.students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student res = null;
        for (Student student:
             students) {
            if (student.getAverageGrade() == averageGrade)
                return student;
        }
        return res;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student res = null;
        if (students.size() > 0) {
            res = students.get(0);
            double maxGrade = res.getAverageGrade();
            for (Student student :
                    students) {
                if (student.getAverageGrade() > maxGrade) {
                    res = student;
                    maxGrade = student.getAverageGrade();
                }
            }
        }
        return res;
    }

    public Student getStudentWithMinAverageGrade() {
        Student res = null;
        if (students.size() > 0) {
            res = students.get(0);
            double minGrade = res.getAverageGrade();
            for (Student student :
                    students) {
                if (student.getAverageGrade() < minGrade) {
                    res = student;
                    minGrade = student.getAverageGrade();
                }
            }
        }
        return res;
    }

    public void expel(Student student) {
        //TODO:
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
}