package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.dao.*;
import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Medicine;
import com.hsbc.hospitalmanagement.domain.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorDAO doctorDAO;
    private final MedicineDAO medicineDAO;
    private final TestDAO testDAO;
    private final AppointmentService appointmentService;

    public DoctorServiceImpl() {
        this.doctorDAO = new DoctorDAOImpl();
        this.medicineDAO = new MedicineDAOImpl();
        this.testDAO = new TestDAOImpl();
        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
        this.appointmentService = new AppointmentServiceImpl(appointmentDAO);  // Use AppointmentService
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        try {
            doctorDAO.registerDoctor(doctor);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Doctor getDoctorById(int id) {
        try {
            return doctorDAO.getDoctor(String.valueOf(id));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        try {
            doctorDAO.updateDoctor(doctor);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDoctor(int id) {
        try {
            doctorDAO.removeDoctor(String.valueOf(id));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cancelAppointment(String appointmentId) {
        return appointmentService.cancelAppointment(appointmentId);
    }

    @Override
    public List<Medicine> suggestMedicines(String criteria) {
        List<Medicine> allMedicines = medicineDAO.getAllMedicines();
        return allMedicines.stream()
                .filter(medicine -> medicine.getDescription().toLowerCase().contains(criteria.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Test> suggestTests(String criteria) {
        List<Test> allTests = testDAO.getAllTests();
        return allTests.stream()
                .filter(test -> test.getDescription().toLowerCase().contains(criteria.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointment> viewAppointments(String doctorId) {
        Doctor doctor = getDoctorById(Integer.parseInt(doctorId)); // Fetch doctor to pass to service
        if (doctor != null) {
            return appointmentService.ViewAppointmentsByDoctor(doctor);
        }
        return List.of();
    }
}
