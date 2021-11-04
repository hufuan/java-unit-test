package com.fuhu.syntax.reference.bbb;

import com.fuhu.syntax.reference.aaa.Student;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    String name;
    String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    List<Student> students = new ArrayList<>();
    public void addStudent(Student student){
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", students=" + students +
                '}';
    }
}
