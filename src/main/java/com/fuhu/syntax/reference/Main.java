package com.fuhu.syntax.reference;

import com.fuhu.syntax.reference.aaa.Student;
import com.fuhu.syntax.reference.bbb.Teacher;

public class Main {

     public static void main(String[] args) {
         Student stu1 = new Student("xiaomin1", 9);
         Student stu2 = new Student("xiaomin2", 10);
         Student stu3 = new Student("xiaomin3", 10);
         Teacher teacher = new Teacher("laochen", "English");
         stu1.assignTeacher(teacher);
         teacher.addStudent(stu2);
         teacher.addStudent(stu1);
         teacher.addStudent(stu3);
         System.out.println(teacher);
    }
}
