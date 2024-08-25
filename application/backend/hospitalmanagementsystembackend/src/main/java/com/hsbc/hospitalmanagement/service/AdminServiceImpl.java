package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.dao.*;
import com.hsbc.hospitalmanagement.domain.Admin;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.exception.ProfileAlreadyExistsException;
import com.hsbc.hospitalmanagement.exception.ProfileNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private final AdminDAO adminDAO;
    private final UserDAO userDAO = new UserDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final ScheduleService scheduleService = new ScheduleServiceImpl();

    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public void registerAdmin(Admin admin) throws ProfileAlreadyExistsException {
        Admin existingAdmin = adminDAO.getAdminById(admin.getId());
        if (existingAdmin != null) {
            throw new ProfileAlreadyExistsException("Admin with ID " + admin.getId() + " already exists.");
        }
        adminDAO.addAdmin(admin);
    }

    @Override
    public Admin getAdminById(String id) throws ProfileNotFoundException {
        Admin admin = adminDAO.getAdminById(id);
        if (admin == null) {
            throw new ProfileNotFoundException("Admin with ID " + id + " not found.");
        }
        return admin;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }

    @Override
    public void updateAdmin(Admin admin) throws ProfileNotFoundException {
        Admin existingAdmin = adminDAO.getAdminById(admin.getId());
        if (existingAdmin == null) {
            throw new ProfileNotFoundException("Admin with ID " + admin.getId() + " not found.");
        }
        adminDAO.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(String id) throws ProfileNotFoundException {
        Admin admin = adminDAO.getAdminById(id);
        if (admin == null) {
            throw new ProfileNotFoundException("Admin with ID " + id + " not found.");
        }
        adminDAO.deleteAdmin(id);
    }

    public void importUsers() {
        System.out.println(userDAO.getAllUsers());
    }

    public void updateDoctorDetails(Doctor doctor) throws SQLException, ProfileNotFoundException {
        Doctor existingDoctor = doctorDAO.getDoctor(doctor.getId().toString());
        if (existingDoctor == null) {
            throw new ProfileNotFoundException("Doctor with ID " + doctor.getId() + " not found.");
        }
        doctorDAO.updateDoctor(doctor);
    }

    public void registerDoctor(Doctor doctor) throws SQLException, ProfileAlreadyExistsException {
        Doctor existingDoctor = doctorDAO.getDoctor(doctor.getUsername());
        if (existingDoctor != null) {
            throw new ProfileAlreadyExistsException("Doctor with username " + doctor.getUsername() + " already exists.");
        }
        doctorDAO.registerDoctor(doctor);
    }

    public void pullDoctorReports() throws SQLException {
        System.out.println(doctorDAO.getAllDoctors());
    }

    public void pullUserReports() throws SQLException {
        System.out.println(userDAO.getAllUsers());
    }

    public void getPatientReportById(String id) throws SQLException, ProfileNotFoundException {
        if (patientDAO.getPatientDetails(id) == null) {
            throw new ProfileNotFoundException("Patient with ID " + id + " not found.");
        }
        System.out.println(patientDAO.getPatientDetails(id));
    }

    public void getAllAppointments() throws SQLException {
        appointmentDAO.getAllAppointments();
    }

    // New method to update a doctor's schedule
    public String updateDoctorSchedule(Appointment appointment) {
        try {
            scheduleService.updateAppointment(appointment);
            return "Doctor's schedule updated successfully.";
        } catch (Exception e) {
            return "Error updating doctor's schedule: " + e.getMessage();
        }
    }

    // New method to view a doctor's schedule
    public List<String> viewDoctorSchedule(String doctorId) {
        try {
            return scheduleService.getAllAppointments(doctorId);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving doctor's schedule: " + e.getMessage());
        }
    }
}
