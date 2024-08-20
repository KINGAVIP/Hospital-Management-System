package com.hsbc.hospitalmanagement.domain;

public class Admin extends Profile{

    final String role = "Admin";

    public Admin() {
    }

    public Admin(String id, String name, String phoneNumber, String username, String password) {
        super(id, name, phoneNumber, username, password);
    }

    public Admin(String id, String name, String phoneNumber, String address, String username, String password) {
        super(id, name, phoneNumber, address, username, password);
    }

    public String getRole() {
        return role;
    }
}
