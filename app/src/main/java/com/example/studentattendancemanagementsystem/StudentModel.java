package com.example.studentattendancemanagementsystem;

public class StudentModel {
    private String id;
    private String name;
    private boolean isPresent;

    public StudentModel(String id, String name) {
        this.id = id;
        this.name = name;
        this.isPresent = false;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isPresent() { return isPresent; }
    public void setPresent(boolean present) { isPresent = present; }
}
