package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Medicine;
import com.hsbc.hospitalmanagement.domain.Test;

import java.util.List;

public interface DoctorService {
    public boolean addDoctor(Doctor doctor);
    public Doctor getDoctorById(int id);
    public boolean updateDoctor(Doctor doctor);
    public boolean deleteDoctor(int id);
    public  boolean cancelAppointment(String appointmentId);
    public List<Medicine> suggestMedicines(String criteria);
    public List<Test> suggestTests(String criteria);
    public List<Appointment> viewAppointments(String DoctorId);
    public List<Doctor> getAllDoctors();
}
