package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.dao.DoctorDAO;
import com.hsbc.hospitalmanagement.dao.DoctorDAOImpl;
import com.hsbc.hospitalmanagement.domain.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorDAO doctorDAO;

    public DoctorServiceImpl() {
        this.doctorDAO = new DoctorDAOImpl();
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        try {
            doctorDAO.registerDoctor(doctor);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Doctor getDoctorById(int id) {
        try {
            return doctorDAO.getDoctor(String.valueOf(id));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        try {
            doctorDAO.updateDoctor(doctor);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDoctor(int id) {
        try {
            doctorDAO.removeDoctor(String.valueOf(id));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Doctor> getAllDoctor() {
        List<Doctor> doctors = new ArrayList<>();
        
        /*
        try {
            doctors = doctorDAO.getAllDoctors();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
        return doctors;
    }
}
