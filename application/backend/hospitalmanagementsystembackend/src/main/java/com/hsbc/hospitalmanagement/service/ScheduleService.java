package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.domain.Appointment;

import java.util.List;

public interface ScheduleService {

    public String addAppointment(Appointment appointment);
    public String deleteApopintment(Appointment appointment);
    public List<String> getAllAppointments(String id);
    public String updateAppointment(Appointment appointment);
}
