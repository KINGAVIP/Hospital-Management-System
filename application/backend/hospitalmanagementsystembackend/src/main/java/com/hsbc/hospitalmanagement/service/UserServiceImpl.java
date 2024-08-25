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
    private final DoctorService doctorService;
    private final AdminService adminService;

    public UserServiceImpl(DoctorService doctorService, AdminService adminService) {
        this.doctorService = doctorService;
        this.adminService = adminService;
        this.userDAO = new UserDAOImpl();
        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
        this.appointmentService = new AppointmentServiceImpl(appointmentDAO);
    }

    @Override
    public void addPatient(Patient patient) {
        userDAO.addUser(new User(patient.getId(), patient.getName(), patient.getPhoneNumber(), patient.getUsername(), patient.getPassword()));
    }


    @Override
    public boolean bookAppointment(Appointment appointment) {

        return appointmentService.bookAppointment(appointment);
    }

    @Override
    public void viewDoctorSchedule(Doctor doctor) {
        doctorService.viewAppointments(doctor.getId());
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
