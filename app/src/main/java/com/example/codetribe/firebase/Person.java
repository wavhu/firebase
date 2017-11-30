package com.example.codetribe.firebase;

/**
 * Created by code tribe on 2017/09/11.
 */

public class Person {
    private String name,surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(){
        super();
    }
}
