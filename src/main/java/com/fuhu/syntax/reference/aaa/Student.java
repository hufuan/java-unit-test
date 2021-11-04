package com.fuhu.syntax.reference.aaa;

import com.fuhu.syntax.reference.bbb.Teacher;

public class Student {
    private String name;
    private int age;
    private Teacher teacher;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void assignTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
