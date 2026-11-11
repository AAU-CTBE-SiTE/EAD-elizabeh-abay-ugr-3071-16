package com.example;

public class Actor {
    private Integer id;
    private String name;
    private Integer age;

    Actor(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setAge(Integer newAge) {
        age = newAge;
    }

}
