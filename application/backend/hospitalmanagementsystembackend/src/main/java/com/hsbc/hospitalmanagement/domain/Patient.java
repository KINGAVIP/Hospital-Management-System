package com.hsbc.hospitalmanagement.domain;

public class Patient extends Profile {

    private String insuranceInfo; // New field for insurance information

    public Patient() {

    }

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
