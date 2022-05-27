package com.example.woocupcoffee1;

public class User{

    // variables for storing
    // our image and name.
    private String name;
    private String imgUrl;

    public User() {
        // empty constructor
        // required for firebase.
    }

    // constructor for our object class.
    public User(String name) {
        this.name = name;
    }

    // getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}