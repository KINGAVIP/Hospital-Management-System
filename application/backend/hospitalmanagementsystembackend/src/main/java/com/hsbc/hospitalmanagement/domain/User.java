package com.hsbc.hospitalmanagement.domain;

public class User extends Profile{

    final String role = "User";

    public User(String id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    public User(String id, String name, String phoneNumber, String address) {
        super(id, name, phoneNumber, address);
    }

    public String getRole() {
        return role;
    }
}
