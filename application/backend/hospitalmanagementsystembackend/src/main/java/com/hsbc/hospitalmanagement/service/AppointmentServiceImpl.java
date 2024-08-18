package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Patient;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService{
    @Override
    public boolean bookAppointment(Appointment appointment) {
        return false;
    }

    @Override
    public boolean cancelAppointment(Appointment appointment) {
        return false;
    }

    @Override
    public List<Appointment> ViewAppointmentsByPatients(Patient patient) {
        return List.of();
    }

    @Override
    public List<Appointment> ViewAppointmentsByDoctor(Doctor doctor) {
        return List.of();
    }
}
