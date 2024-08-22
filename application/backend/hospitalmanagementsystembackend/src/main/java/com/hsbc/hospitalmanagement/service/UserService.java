package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Patient;

public interface UserService {
    void addPatient(Patient patient);

    Patient getPatientById(String patientId);

    void updatePatient(Patient patient);

    void deletePatient(String patientId);

    Appointment bookAppointment(Appointment appointment);

    void viewDoctorSchedule(Doctor doctor);

    void viewAppointments();

    boolean login(String userName, String password);

    boolean cancelAppointment(Appointment appointment);


}
