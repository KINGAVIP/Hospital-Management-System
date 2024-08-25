package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.dao.AppointmentDAO;
import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Patient;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentDAO appointmentDAO;

    public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public boolean bookAppointment(Appointment appointment) {
        try {
            appointmentDAO.addAppointment(appointment);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cancelAppointment(String appointmentId) {
        try {
            appointmentDAO.deleteAppointment(appointmentId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly in real application
            return false;
        }
    }

    @Override
    public List<Appointment> ViewAppointmentsByPatients(Patient patient) {
        try {
            List<Appointment> allAppointments = appointmentDAO.getAllAppointments();
            return allAppointments.stream()
                    .filter(appointment -> appointment.getPatientId().equals(patient.getId()))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly in real application
            return List.of(); // Return empty list if there's an error
        }
    }

    @Override
    public List<Appointment> ViewAppointmentsByDoctor(Doctor doctor) {
        try {
            List<Appointment> allAppointments = appointmentDAO.getAllAppointments();
            return allAppointments.stream()
                    .filter(appointment -> appointment.getDoctorId().equals(doctor.getId()))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly in real application
            return List.of(); // Return empty list if there's an error
        }
    }
}
