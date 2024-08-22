package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.dao.AppointmentDAO;
import com.hsbc.hospitalmanagement.dao.AppointmentDAOImpl;
import com.hsbc.hospitalmanagement.dao.UserDAO;
import com.hsbc.hospitalmanagement.dao.UserDAOImpl;
import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Patient;
import com.hsbc.hospitalmanagement.domain.User;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final AppointmentService appointmentService;

    public UserServiceImpl() {
        this.userDAO = new UserDAOImpl();
        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
        this.appointmentService = new AppointmentServiceImpl(appointmentDAO);
    }

    @Override
    public void addPatient(Patient patient) {

    }


    @Override
    public boolean bookAppointment(Appointment appointment) {

        return appointmentService.bookAppointment(appointment);
    }

    @Override
    public void viewDoctorSchedule(Doctor doctor) {

    }

    @Override
    public void viewAppointments() {

    }

    @Override
    public boolean login(String userName, String password) {

        User user = userDAO.getUserByUsername(userName);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelAppointment(String appointmentId) {

        return appointmentService.cancelAppointment(appointmentId);
    }
}
