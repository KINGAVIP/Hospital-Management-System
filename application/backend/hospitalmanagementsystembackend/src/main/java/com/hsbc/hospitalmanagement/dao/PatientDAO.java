package com.hsbc.hospitalmanagement.dao;
import com.hsbc.hospitalmanagement.domain.Patient;
import com.hsbc.hospitalmanagement.utils.ConManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDAO {

    private static final String CREATE_PATIENTS_TABLE =
            "CREATE TABLE IF NOT EXISTS patients (" +
                    "id VARCHAR(255) PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "phone_number VARCHAR(255), " +
                    "address VARCHAR(255), " +
                    "insurance_info VARCHAR(255)" + // New column for insurance information
                    ");";

    private static final String INSERT_PATIENT =
            "INSERT INTO patients (id, name, phone_number, address, insurance_info) VALUES (?, ?, ?, ?, ?)";

    public void createTable() throws SQLException {
        try (Connection connection = ConManager.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(CREATE_PATIENTS_TABLE);
            System.out.println("Patients table created or modified successfully.");
        }
    }

    public void savePatient(Patient patient) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT)) {
            preparedStatement.setString(1, patient.getId());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getPhoneNumber());
            preparedStatement.setString(4, patient.getAddress());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Patient saved successfully.");
            } else {
                System.out.println("Failed to save patient.");
            }
        }
    }
}
