package com.hsbc.hospitalmanagement.domain;

public class User extends Profile{

    final String role = "User";

    public User() {
    }

    public User(String id, String name, String phoneNumber, String username, String password) {
        super(id, name, phoneNumber, username, password);
    }

    public User(String id, String name, String phoneNumber, String address, String username, String password) {
        super(id, name, phoneNumber, address, username, password);
    }

    public String getRole() {
        return role;
    }
}
