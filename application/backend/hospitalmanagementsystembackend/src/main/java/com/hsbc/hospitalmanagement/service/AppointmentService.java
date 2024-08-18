package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Patient;

import java.util.List;

public interface AppointmentService {
    public boolean bookAppointment (Appointment appointment);
    public boolean cancelAppointment (Appointment appointment);
    public List<Appointment> ViewAppointmentsByPatients(Patient patient);
    public List<Appointment> ViewAppointmentsByDoctor(Doctor doctor);
}
