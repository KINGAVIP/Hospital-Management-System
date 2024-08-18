package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Profile;
import com.hsbc.hospitalmanagement.domain.User;

public class AuthServiceImpl implements AuthService{


    @Override
    public Profile doLogin(String userName, String password) {
        Profile profile = null;
        return profile;
    }

    @Override
    public User doRegisterUser(String name, String phoneNumber) {
        return null;
    }

    @Override
    public User doRegisterUser(String name, String phoneNumber, String address) {
        return null;
    }

    @Override
    public Doctor doRegisterDoctor(String name, String phoneNumber) {
        return null;
    }

    @Override
    public Doctor doRegisterDoctor(String name, String phoneNumber, String address) {
        return null;
    }
}
