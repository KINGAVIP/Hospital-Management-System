package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;

import java.util.List;

public interface DoctorService {
    public boolean addDoctor(Doctor doctor);
    public Doctor getDoctorById(int id);
    public boolean updateDoctor(Doctor doctor);
    public boolean deleteDoctor(int id);
    public List<Doctor> getAllDoctor();
    public  boolean cancelAppointment(Appointment appointment);
}
