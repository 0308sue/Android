package com.example.myapp08_intent;

import java.io.Serializable;

public class Student implements Serializable {

    private int sno;
    private String name;
    private String major;

    public Student() {
    }

    public Student(int sno, String name, String major) {
        this.sno = sno;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
