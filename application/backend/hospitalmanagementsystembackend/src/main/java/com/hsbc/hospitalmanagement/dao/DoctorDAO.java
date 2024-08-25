package com.hsbc.hospitalmanagement.dao;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Schedule;

import javax.print.Doc;
import java.sql.SQLException;
import java.util.List;

import static com.google.protobuf.JavaFeaturesProto.java;

public interface DoctorDAO {
    void registerDoctor(Doctor doctor) throws SQLException;
    void updateDoctor(Doctor doctor) throws SQLException;
    void removeDoctor(String id) throws SQLException;
    Doctor getDoctor(String id) throws SQLException;
    List<Schedule> getDoctorSchedule(String id) throws SQLException;
    void updateDoctorSchedule(String id, Schedule schedule) throws SQLException;
    public List<Doctor> getAllDoctors() throws SQLException;
}
