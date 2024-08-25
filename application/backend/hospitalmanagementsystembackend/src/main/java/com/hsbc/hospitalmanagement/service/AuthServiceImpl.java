package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.dao.*;
import com.hsbc.hospitalmanagement.domain.Admin;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Profile;
import com.hsbc.hospitalmanagement.domain.User;
import com.hsbc.hospitalmanagement.exception.AuthenticationFailedException;

import javax.print.Doc;
import java.sql.SQLException;

public class AuthServiceImpl implements AuthService{

    private DoctorDAO doctorDAO = new DoctorDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();
    private AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public Profile doLoginDoctor(String userName, String password) throws AuthenticationFailedException{
        try {
            for(Doctor doctor: doctorDAO.getAllDoctors()) {
                if (doctor.getUsername().equals(userName) && doctor.getPassword().equals(password)) return doctor;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new AuthenticationFailedException();
    }

    @Override
    public Profile doLoginUser(String userName, String password) throws AuthenticationFailedException {
        for(User user: userDAO.getAllUsers()) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) return user;
        }
        throw new AuthenticationFailedException();
    }

    @Override
    public Profile doLoginAdmin(String userName, String password) throws AuthenticationFailedException {
        for(Admin admin: adminDAO.getAllAdmins()) {
            if (admin.getUsername().equals(userName) && admin.getPassword().equals(password)) return admin;
        }
        throw new AuthenticationFailedException();
    }

    @Override
    public User doRegisterUser(String id, String name, String phoneNumber, String username, String password) {
        User newUser = new User(id, name, phoneNumber, username, password);
        userDAO.addUser(newUser);
        return newUser;
    }

    @Override
    public User doRegisterUser(String id, String name, String username, String password) {
        User newUser = new User(id, name, username, password);
        userDAO.addUser(newUser);
        return newUser;
    }

    @Override
    public Doctor doRegisterDoctor(String id, String name, String phoneNumber, String username, String password) {
        Doctor doctor = new Doctor(id, name, phoneNumber, username, password);
        try {
            doctorDAO.registerDoctor(doctor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doctor;
    }

    @Override
    public Doctor doRegisterDoctor(String id, String name, String username, String password) {
        Doctor doctor = new Doctor(id, name, username, password);
        try {
            doctorDAO.registerDoctor(doctor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doctor;
    }
}
