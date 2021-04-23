package com.fuhu.jason;

public class User {
    private String name;
    private int password;

    public User() {
        this("unknow", 123456); //传递0参时默认用户名未知 密码123465
    }

    public User(String name) { //传递1参时默认密码123456
        this(name, 123456);
    }

    public User(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}
