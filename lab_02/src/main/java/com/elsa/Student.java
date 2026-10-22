package com.elsa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    String name;
    String tech;
    @Id
    int id;

    Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public void setId(int id) {
        this.id = id;
    }
}
