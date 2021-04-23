package com.fuhu.java;

import java.util.Arrays;
import java.util.List;

public class Sample {
    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE,22),
                new Person("Bob", Gender.MALE,20),
                new Person("Paula", Gender.FEMALE,32),
                new Person("Paul", Gender.MALE,32),
                new Person("Jack", Gender.MALE,2),
                new Person("Jack", Gender.MALE,72),
                new Person("Jil", Gender.FEMALE,42)
        );
    }
    public static void main(String argv[]) {
        String ret = createPeople().stream()
                .parallel()
                .filter(person -> person.getGender()==Gender.FEMALE)
                .filter(person -> person.getAge()>30).map(Person::getName)
                .map(String::toUpperCase)
                .findAny().orElse("no one");
        System.out.println("ret= " + ret);
    }
}

class Sleep {
    static void sleep(int mili) {
        try {
            Thread.sleep(mili);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}