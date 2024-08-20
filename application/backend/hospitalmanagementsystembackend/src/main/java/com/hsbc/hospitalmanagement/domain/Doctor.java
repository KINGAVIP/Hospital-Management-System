package com.hsbc.hospitalmanagement.domain;

public class Doctor extends Profile {
    private static final String ROLE = "Doctor";
    private String specialization;

    public Doctor(String specialization) {
        this.specialization = specialization;
    }

    public Doctor(String id, String name, String phoneNumber, String username, String password, String specialization) {
        super(id, name, phoneNumber, username, password);
        this.specialization = specialization;
    }

    public Doctor(String id, String name, String phoneNumber, String address, String username, String password, String specialization) {
        super(id, name, phoneNumber, address, username, password);
        this.specialization = specialization;
    }

    // Getters and setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getRole() {
        return ROLE;
    }
}
