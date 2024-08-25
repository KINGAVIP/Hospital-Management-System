package com.hsbc.hospitalmanagement.service;

import com.hsbc.hospitalmanagement.dao.*;
import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Medicine;
import com.hsbc.hospitalmanagement.domain.Test;
import com.hsbc.hospitalmanagement.exception.ProfileAlreadyExistsException;
import com.hsbc.hospitalmanagement.exception.ProfileNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorDAO doctorDAO;
    private final MedicineDAO medicineDAO;
    private final TestDAO testDAO;
    private final AppointmentService appointmentService;

    private final ScheduleService scheduleService = new ScheduleServiceImpl();

    public DoctorServiceImpl() {
        this.doctorDAO = new DoctorDAOImpl();
        this.medicineDAO = new MedicineDAOImpl();
        this.testDAO = new TestDAOImpl();
        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
        this.appointmentService = new AppointmentServiceImpl(appointmentDAO);  // Use AppointmentService
    }

    @Override
    public boolean addDoctor(Doctor doctor) throws ProfileAlreadyExistsException {
        try {
            Doctor existingDoctor = doctorDAO.getDoctor(doctor.getUsername());
            if (existingDoctor != null) {
                throw new ProfileAlreadyExistsException("Doctor with username " + doctor.getUsername() + " already exists.");
            }
            doctorDAO.registerDoctor(doctor);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Doctor getDoctorById(int id) throws ProfileNotFoundException {
        try {
            Doctor doctor = doctorDAO.getDoctor(String.valueOf(id));
            if (doctor == null) {
                throw new ProfileNotFoundException("Doctor with ID " + id + " not found.");
            }
            return doctor;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateDoctor(Doctor doctor) throws ProfileNotFoundException {
        try {
            Doctor existingDoctor = doctorDAO.getDoctor(doctor.getId().toString());
            if (existingDoctor == null) {
                throw new ProfileNotFoundException("Doctor with ID " + doctor.getId() + " not found.");
            }
            doctorDAO.updateDoctor(doctor);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDoctor(int id) throws ProfileNotFoundException {
        try {
            Doctor doctor = doctorDAO.getDoctor(String.valueOf(id));
            if (doctor == null) {
                throw new ProfileNotFoundException("Doctor with ID " + id + " not found.");
            }
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
    public List<Appointment> viewAppointments(String doctorId) throws ProfileNotFoundException {
        Doctor doctor = getDoctorById(Integer.parseInt(doctorId)); // Fetch doctor to pass to service
        if (doctor != null) {
            return appointmentService.ViewAppointmentsByDoctor(doctor);
        } else {
            throw new ProfileNotFoundException("Doctor with ID " + doctorId + " not found.");
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {
        try {
            return doctorDAO.getAllDoctors();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String updateDoctorSchedule(Appointment appointment) {
        return scheduleService.updateAppointment(appointment);
    }

    public String setupRecurringSchedule(Appointment appointment) {
        try {
            for (int i = 0; i < 10; i++) { // Set up a schedule for 30 days (every 3 days)
                scheduleService.addAppointment(appointment);
                appointment.setAppointmentDateTime(appointment.getAppointmentDateTime().plusDays(3));
            }
            return "Recurring schedule set up successfully.";
        } catch (Exception e) {
            return "Error setting up recurring schedule: " + e.getMessage();
        }
    }
}
