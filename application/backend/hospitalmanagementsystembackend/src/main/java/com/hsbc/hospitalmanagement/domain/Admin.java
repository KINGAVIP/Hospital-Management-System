package com.hsbc.hospitalmanagement.domain;

public class Admin extends Profile{

    final String role = "Admin";

    public Admin(String id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    public Admin(String id, String name, String phoneNumber, String address) {
        super(id, name, phoneNumber, address);
    }

    public String getRole() {
        return role;
    }
}
