package com.example.myapp20;

public class Member {
    private Long num;
    private String name;
    private int age;
    private String phone;
    private String address;
    private String email;

    public Member(String name, int age, String phone, String address, String email) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
