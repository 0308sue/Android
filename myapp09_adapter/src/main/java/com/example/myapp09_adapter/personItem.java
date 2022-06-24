package com.example.myapp09_adapter;

public class personItem {
    String name;
    String message;
    String phone;
    int resourceId;

    public personItem(String name, String message, String phone, int resourceId) {
        this.name = name;
        this.message = message;
        this.phone = phone;
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
