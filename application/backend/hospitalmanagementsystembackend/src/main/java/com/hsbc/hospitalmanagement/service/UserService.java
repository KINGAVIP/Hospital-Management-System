package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Patient;

public interface UserService {
    void addPatient(Patient patient);

    boolean bookAppointment(Appointment appointment);

    void viewDoctorSchedule(Doctor doctor);

    boolean login(String userName, String password);

    boolean cancelAppointment(String appointmentId);
}
