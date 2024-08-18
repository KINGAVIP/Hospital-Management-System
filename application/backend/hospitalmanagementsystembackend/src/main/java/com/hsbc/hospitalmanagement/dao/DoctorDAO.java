package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.utils.ConManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorDAO {

    private static final String CREATE_DOCTORS_TABLE =
            "CREATE TABLE IF NOT EXISTS doctors (" +
                    "id VARCHAR(255) PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "phone_number VARCHAR(20) NOT NULL, " +
                    "address VARCHAR(255), " +
                    "role VARCHAR(50) NOT NULL" +
                    ");";

    private static final String INSERT_DOCTOR =
            "INSERT INTO doctors (id, name, phone_number, address, role) VALUES (?, ?, ?, ?, ?)";

    public void createTable() throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DOCTORS_TABLE)) {
            preparedStatement.execute();
            System.out.println("Doctors table created successfully.");
        }
    }

    public void saveDoctor(Doctor doctor) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOCTOR)) {
            preparedStatement.setString(1, doctor.getId());
            preparedStatement.setString(2, doctor.getName());
            preparedStatement.setString(3, doctor.getPhoneNumber());
            preparedStatement.setString(4, doctor.getAddress());
            preparedStatement.setString(5, doctor.getRole());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Doctor saved successfully.");
            } else {
                System.out.println("Failed to save doctor.");
            }
        }
    }
}
