package com.example.myloginapp;

public class User {
    public boolean available;
    public String name;

    public User(String name, boolean available) {
        this.name = name;
        this.available = available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setName(String name) {
        this.name = name;
    }
}
