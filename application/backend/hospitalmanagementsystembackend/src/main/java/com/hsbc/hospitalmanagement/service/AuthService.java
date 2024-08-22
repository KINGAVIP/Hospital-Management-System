package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Profile;
import com.hsbc.hospitalmanagement.domain.User;
import com.hsbc.hospitalmanagement.exception.AuthenticationFailedException;

import javax.print.Doc;

public interface AuthService {

    public Profile doLoginDoctor(String userName, String password) throws AuthenticationFailedException;
    public Profile doLoginUser(String userName, String password) throws AuthenticationFailedException;
    public Profile doLoginAdmin (String userName, String password) throws AuthenticationFailedException;
    public User doRegisterUser(String id, String name, String phoneNumber, String username, String password);
    public User doRegisterUser(String id, String name, String username, String password);
    public Doctor doRegisterDoctor(String id, String name, String phoneNumber, String username, String password);
    public Doctor doRegisterDoctor(String id, String name, String username, String password);

}
