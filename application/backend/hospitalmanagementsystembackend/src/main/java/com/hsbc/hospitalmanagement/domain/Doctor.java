package com.hsbc.hospitalmanagement.domain;

public class Doctor extends Profile {
    private static final String ROLE = "Doctor";
    private String specialization;
    private String username;
    private String password;

    public Doctor(String id, String name, String phoneNumber, String address, String specialization, String username, String password) {
        super(id, name, phoneNumber, address);
        this.specialization = specialization;
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return ROLE;
    }
}
