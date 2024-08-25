package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.dao.ScheduleDAO;
import com.hsbc.hospitalmanagement.dao.ScheduleDAOImpl;
import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.exception.AppointmentCreationError;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService{

    private ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    @Override
    public String addAppointment(Appointment appointment) {
        try {
            scheduleDAO.addAppointment(appointment);
            return "Appointment created";
        } catch (AppointmentCreationError e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteApopintment(Appointment appointment) {

        if (scheduleDAO.deleteAppointment(appointment.getDoctorId(), appointment.getAppointmentDateTime().toString())) {
            return "Appointment deleted";
        }
        return "error deleting appointment";


    }

    @Override
    public List<String> getAllAppointments(String id) {
        return scheduleDAO.getAllAppointments(id);
    }

    @Override
    public String updateAppointment(Appointment appointment) {
        try {
            scheduleDAO.updateAppointment(appointment);
        } catch (AppointmentCreationError e) {
            return "Error updating appointment";
        }
        return "Appointment updated successfully";
    }
}
