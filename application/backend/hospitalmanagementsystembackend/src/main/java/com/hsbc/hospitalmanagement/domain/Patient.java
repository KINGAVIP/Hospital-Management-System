package com.hsbc.hospitalmanagement.domain;

public class Patient extends Profile {

    private String insuranceInfo; // New field for insurance information
    private String username; // New field for insurance information



    public Patient() {

    }

    public Patient(String id, String name, String phoneNumber, String address, String insuranceInfo, String username, String password) {
        super(id, name, phoneNumber, address);
        this.insuranceInfo = insuranceInfo;
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password; // New field for insurance information


    public Patient(String id, String name, String phoneNumber, String address, String insuranceInfo) {
        super(id, name, phoneNumber, address);
        this.insuranceInfo = insuranceInfo;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }
}
