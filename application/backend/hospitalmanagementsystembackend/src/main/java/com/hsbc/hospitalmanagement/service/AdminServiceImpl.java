package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.dao.*;
import com.hsbc.hospitalmanagement.domain.Admin;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.service.AdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private final AdminDAO adminDAO;
    private final UserDAO userDAO = new UserDAOImpl();
    DoctorDAO doctorDAO = new DoctorDAOImpl();
    PatientDAO patientDAO = new PatientDAOImpl();
    AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;

    }

    @Override
    public void registerAdmin(Admin admin) {
        adminDAO.addAdmin(admin);
    }

    @Override
    public Admin getAdminById(String id) {
        return adminDAO.getAdminById(id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDAO.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(String id) {
        adminDAO.deleteAdmin(id);
    }

    public void importUsers(){
        System.out.println(userDAO.getAllUsers());
    }
    public void updateDoctorDetails(Doctor doctor) throws SQLException {
        doctorDAO.updateDoctor(doctor);
    }
    public void registerDoctor(Doctor doctor) throws SQLException {
        doctorDAO.registerDoctor(doctor);
    }
    public void pullDoctorReports() throws SQLException {
        System.out.println(doctorDAO.getAllDoctors());
    }
    public void pullUserReports()  throws SQLException {
        System.out.println(userDAO.getAllUsers());
    }
    public void pullPatientReports()  throws SQLException {
        System.out.println(patientDAO.getAllPatients());


    }
    public void getPatientReportById(String id) throws SQLException {
        System.out.println(patientDAO.getPatientDetails(id));
    }
    public void getAllAppointments() throws SQLException {
        appointmentDAO.getAllAppointments();
    }

}
