package com.mycompany.fuhu.callback;

import java.util.ArrayList;
import java.util.List;
public class Demo {
    String name;
    public Demo(String name) {
        this.name = name;
    }
    private Callback callbackHandler  = (str1, str2) -> {
        System.out.println("input str1: " + str1 + " str2: " + str2);
        System.out.println("Master: " + name);
        return 0;
    };

    List createStudents(int num)
    {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String name = "a_san"  + i;
            Student stu =new Student(i, name);
            if (i%100 == 0) {
                stu.setCallbackHandler(callbackHandler);
            }
            list.add(stu);
        }
        return list;
    }
    void processStudents(List list) {
        list.stream().forEach(s ->  ((Student)s).notifyOther());
    }
    void sleep(int num)
    {
        try {
            Thread.sleep(num*1000);
        } catch (Exception e) {
            System.out.println("ignore exception");
        }
    }
    public static void main(String argv[])
    {
        Demo demo= new Demo("myDemo");
        List list = demo.createStudents(1000);
        demo.processStudents(list);
        demo.sleep(1);
        System.out.println("call gc");
        System.gc();
        demo.sleep(2);
    }
}
