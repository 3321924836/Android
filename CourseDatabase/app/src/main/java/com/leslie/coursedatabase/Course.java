package com.leslie.coursedatabase;

public class Course {
    private String number;
    private String name;
    private Integer credit;

    public Course(String number, String name, Integer credit) {
        this.number = number;
        this.name = name;
        this.credit = credit;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Integer getCredit() {
        return credit;
    }
}
