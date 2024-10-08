package com.hsbc.hospitalmanagement.domain;

public class User extends Profile {

    final String role = "User";
    private String username;
    private String password;

    public User(String id, String name, String phoneNumber, String username, String password) {
        super(id, name, phoneNumber);
        this.username = username;
        this.password = password;
    }

    public User(String id, String name, String phoneNumber, String address, String username, String password) {
        super(id, name, phoneNumber, address);
        this.username = username;
        this.password = password;
    }

    public User(String id, String name, String username, String password) {
        super (id, name);
        this.username = username;
        this.password = password;
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
