package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Patient;

public class UserServiceImpl implements UserService {
    @Override
    public void addPatient(Patient patient) {

    }

    @Override
    public Patient getPatientById(String patientId) {
        return null;
    }

    @Override
    public void updatePatient(Patient patient) {

    }

    @Override
    public void deletePatient(String patientId) {

    }

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public void viewDoctorSchedule(Doctor doctor) {

    }

    @Override
    public void viewAppointments() {

    }

    @Override
    public boolean login(String userName, String password) {
        return false;
    }

    @Override
    public boolean cancelAppointment(Appointment appointment) {
        return false;
    }
}
