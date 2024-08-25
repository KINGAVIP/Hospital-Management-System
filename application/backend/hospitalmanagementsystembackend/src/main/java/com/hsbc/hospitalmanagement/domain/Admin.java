package com.hsbc.hospitalmanagement.domain;

public class Admin extends Profile{

    final String role = "Admin";
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(String id, String name, String phoneNumber, String username, String password) {
        super(id, name, phoneNumber, username, password);
    }

    public Admin(String id, String name, String phoneNumber, String address, String username, String password) {
        super(id, name, phoneNumber, address, username, password);
        this.username=username;
        this.password=password;
    }

    public String getRole() {
        return role;
    }

    public String getUserame() {
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
