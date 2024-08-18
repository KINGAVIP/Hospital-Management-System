package com.hsbc.hospitalmanagement.domain;

public class User extends Profile{
    private String username;
    private String password;

    final String role = "User";
    public User() {

    }
    public User(String id, String name, String phoneNumber, String username, String password) {
        super(id, name, phoneNumber);
        this.username = username;
        this.password = password;
    }

    public User(String id, String name, String phoneNumber, String address) {
        super(id, name, phoneNumber, address);
    }

    public String getRole() {
        return role;
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

}
