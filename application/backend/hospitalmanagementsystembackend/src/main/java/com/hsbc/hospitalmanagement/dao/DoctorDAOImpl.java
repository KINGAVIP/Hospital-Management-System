package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.domain.Schedule;
import com.hsbc.hospitalmanagement.utils.ConManager;

import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    private static final String INSERT_DOCTOR_SQL = "INSERT INTO doctors (id, name, phone_number, address, specialization, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_DOCTOR_SQL = "UPDATE doctors SET name = ?, phone_number = ?, address = ?, specialization = ?, username = ?, password = ? WHERE id = ?";
    private static final String DELETE_DOCTOR_SQL = "DELETE FROM doctors WHERE id = ?";
    private static final String SELECT_DOCTOR_SQL = "SELECT * FROM doctors WHERE id = ?";
    private static final String SELECT_ALL_DOCTORS = "SELECT * FROM doctors WHERE id = ?";

    @Override
    public void registerDoctor(Doctor doctor) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOCTOR_SQL)) {

            preparedStatement.setString(1, doctor.getId());
            preparedStatement.setString(2, doctor.getName());
            preparedStatement.setString(3, doctor.getPhoneNumber());
            preparedStatement.setString(4, doctor.getAddress());
            preparedStatement.setString(5, doctor.getSpecialization());
            preparedStatement.setString(6, doctor.getUsername());
            preparedStatement.setString(7, doctor.getPassword());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTOR_SQL)) {

            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getPhoneNumber());
            preparedStatement.setString(3, doctor.getAddress());
            preparedStatement.setString(4, doctor.getSpecialization());
            preparedStatement.setString(5, doctor.getUsername());
            preparedStatement.setString(6, doctor.getPassword());
            preparedStatement.setString(7, doctor.getId());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void removeDoctor(String id) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOCTOR_SQL)) {

            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Doctor getDoctor(String id) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCTOR_SQL)) {

            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Doctor(
                            resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("address"),
                            resultSet.getString("specialization"),
                            resultSet.getString("username"),
                            resultSet.getString("password")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Doctor> getAllDoctors() throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOCTORS)) {

            List<Doctor> result = new ArrayList<>();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    result.add(new Doctor(
                            resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("address"),
                            resultSet.getString("specialization"),
                            resultSet.getString("username"),
                            resultSet.getString("password")
                    ));
                } else {
                    return null;
                }
            }
            return result;
        }
    }

    @Override
    public List<Schedule> getDoctorSchedule(String id) throws SQLException {
        return null;
    }

    @Override
    public void updateDoctorSchedule(String id, Schedule schedule) throws SQLException {

        return;
    }
}
