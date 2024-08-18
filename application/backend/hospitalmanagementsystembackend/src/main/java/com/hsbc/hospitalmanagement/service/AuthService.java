package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Profile;
import com.hsbc.hospitalmanagement.domain.User;

import javax.print.Doc;

public interface AuthService {

    public Profile doLogin(String userName, String password);
    public User doRegisterUser(String name, String phoneNumber);
    public User doRegisterUser(String name, String phoneNumber, String address);
    public Doctor doRegisterDoctor(String name, String phoneNumber);
    public Doctor doRegisterDoctor(String name, String phoneNumber, String address);

}
