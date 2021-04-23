package com.fuhu.java;

public class Person {
    String name;
    Gender gender;
    int age;
    public Person(String theName, Gender theGenDer, int theAge) {
        name= theName;
        gender= theGenDer;
        age=theAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
