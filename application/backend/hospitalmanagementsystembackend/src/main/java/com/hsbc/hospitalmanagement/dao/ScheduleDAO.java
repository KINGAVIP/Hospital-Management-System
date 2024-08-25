package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.exception.AppointmentCreationError;

import java.util.List;

public interface ScheduleDAO {

    public boolean addAppointment(Appointment appointment) throws AppointmentCreationError;
    public boolean deleteAppointment(String doctorId, String dateTime);
    public List<String> getAllAppointments(String doctorId);
    public boolean updateAppointment(Appointment appointment) throws AppointmentCreationError;
}
