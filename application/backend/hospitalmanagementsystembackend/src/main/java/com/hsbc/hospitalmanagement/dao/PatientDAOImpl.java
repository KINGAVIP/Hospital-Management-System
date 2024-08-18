package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Patient;
import com.hsbc.hospitalmanagement.utils.ConManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAOImpl implements PatientDAO{
    private static final String INSERT_PATIENT_SQL = "INSERT INTO patients (id, name, phone_number, address, insurance, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_PATIENT_SQL = "SELECT * FROM patients WHERE id = ?";
    private static final String UPDATE_PATIENT_SQL = "UPDATE patients SET name = ?, phone_number = ?, address = ?, insurance = ?, username = ?, password = ? WHERE id = ?";

    @Override
    public void registerPatient(Patient patient) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT_SQL)) {

            preparedStatement.setString(1, patient.getId());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getPhoneNumber());
            preparedStatement.setString(4, patient.getAddress());
            preparedStatement.setString(5, patient.getInsuranceInfo());
            preparedStatement.setString(6, patient.getUsername());
            preparedStatement.setString(7, patient.getPassword());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updatePatient(Patient patient) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PATIENT_SQL)) {

            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getPhoneNumber());
            preparedStatement.setString(3, patient.getAddress());
            preparedStatement.setString(4, patient.getInsuranceInfo());
            preparedStatement.setString(5, patient.getUsername());
            preparedStatement.setString(6, patient.getPassword());
            preparedStatement.setString(7, patient.getId());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Patient getPatientDetails(String patientId) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_SQL)) {

            preparedStatement.setString(1, patientId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Patient(
                            resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("address"),
                            resultSet.getString("insurance"),
                            resultSet.getString("username"),
                            resultSet.getString("password")
                    );
                } else {
                    return null;
                }
            }
        }
    }
}
