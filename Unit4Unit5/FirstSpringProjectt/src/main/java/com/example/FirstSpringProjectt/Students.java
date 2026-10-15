package com.example.FirstSpringProjectt;

public class Students {

    private long id;
    private String name;
    private String email;
    private String branch;
    private int year;
    private double cgpa;

    public Students() {
        this.name = "Nilesh";
        this.id = 12345;
        this.email = "nilesh@example.com";
        this.branch = "Information Technology";
        this.year = 3;  
        this.cgpa = 8.5;
    }

    public Students(long id, String name, String email, String branch, int year, double cgpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.year = year;
        this.cgpa = cgpa;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
    
}
