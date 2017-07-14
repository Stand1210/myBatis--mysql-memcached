package com.weibo.api.users.model;

public class User {
    private long id;
    private String name;
    private int age;
    private String gender;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGander(String gender) {
        this.gender = gender;
    }
    
    public String toString() {
        return "id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender;
    }
}
