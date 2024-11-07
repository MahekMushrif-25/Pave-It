package com.example.test;

public class RequestItem {
    private String name;
    private int age;
    private String number;
    private String location;
    private int imageResId;
    private String status;

    // Constructor
    public RequestItem(String name, int age, String number, String location, int imageResId, String status) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.location = location;
        this.imageResId = imageResId;
        this.status = status;
    }

    // Getters and Setters
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
