package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Medicine;
import com.hsbc.hospitalmanagement.domain.Test;
import com.hsbc.hospitalmanagement.exception.ProfileAlreadyExistsException;
import com.hsbc.hospitalmanagement.exception.ProfileNotFoundException;

import java.util.List;

public interface DoctorService {
    public boolean addDoctor(Doctor doctor) throws ProfileAlreadyExistsException;
    public Doctor getDoctorById(int id) throws ProfileNotFoundException;
    public boolean updateDoctor(Doctor doctor) throws ProfileNotFoundException;
    public boolean deleteDoctor(int id) throws ProfileNotFoundException;
    public  boolean cancelAppointment(String appointmentId);
    public List<Medicine> suggestMedicines(String criteria);
    public List<Test> suggestTests(String criteria);
    public List<Appointment> viewAppointments(String DoctorId) throws ProfileNotFoundException;
    public List<Doctor> getAllDoctors();
}
