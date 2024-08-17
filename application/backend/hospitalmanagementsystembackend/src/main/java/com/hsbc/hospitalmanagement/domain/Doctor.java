package com.hsbc.hospitalmanagement.domain;

public class Doctor extends Profile{

    final String role = "Doctor";

    public Doctor(String id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    public Doctor(String id, String name, String phoneNumber, String address) {
        super(id, name, phoneNumber, address);
    }

    public String getRole() {
        return role;
    }
}
