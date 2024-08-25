package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Appointment;
import java.sql.SQLException;
import java.util.List;

public interface AppointmentDAO {

    void addAppointment(Appointment appointment) throws SQLException;

    void updateAppointment(Appointment appointment) throws SQLException;

    void deleteAppointment(String appointmentId) throws SQLException;

    Appointment getAppointmentById(String appointmentId) throws SQLException;

    List<Appointment> getAllAppointments() throws SQLException;
}
