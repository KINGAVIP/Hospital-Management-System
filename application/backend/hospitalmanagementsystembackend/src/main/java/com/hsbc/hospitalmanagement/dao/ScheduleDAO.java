package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Appointment;

import java.util.List;

public interface ScheduleDAO {

    public boolean addAppointment(Appointment appointment);
    public boolean deleteAppointment(Appointment appointment);
    public List<String> getAllAppointments(String doctorId);
}
