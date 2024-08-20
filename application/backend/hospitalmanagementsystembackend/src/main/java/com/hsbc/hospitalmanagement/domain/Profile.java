package com.hsbc.hospitalmanagement.domain;

public abstract class Profile {
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;

    public Profile() {
    }

    public Profile(String id, String name, String phoneNumber, String username, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    public Profile(String id, String name, String phoneNumber, String address, String username, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
