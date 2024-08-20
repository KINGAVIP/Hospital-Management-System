package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.utils.ConManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    private static final String INSERT_APPOINTMENT_SQL = "INSERT INTO appointments (appointment_id, user_id, doctor_id, patient_id, appointment_datetime) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_APPOINTMENT_SQL = "UPDATE appointments SET user_id = ?, doctor_id = ?, patient_id = ?, appointment_datetime = ? WHERE appointment_id = ?";
    private static final String DELETE_APPOINTMENT_SQL = "DELETE FROM appointments WHERE appointment_id = ?";
    private static final String SELECT_APPOINTMENT_SQL = "SELECT * FROM appointments WHERE appointment_id = ?";
    private static final String SELECT_ALL_APPOINTMENTS_SQL = "SELECT * FROM appointments";

    @Override
    public void addAppointment(Appointment appointment) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT_SQL)) {

            preparedStatement.setString(1, appointment.getAppointmentId());
            preparedStatement.setString(2, appointment.getUserId());
            preparedStatement.setString(3, appointment.getDoctorId());
            preparedStatement.setString(4, appointment.getPatientId());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(appointment.getAppointmentDateTime()));

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateAppointment(Appointment appointment) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_APPOINTMENT_SQL)) {

            preparedStatement.setString(1, appointment.getUserId());
            preparedStatement.setString(2, appointment.getDoctorId());
            preparedStatement.setString(3, appointment.getPatientId());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(appointment.getAppointmentDateTime()));
            preparedStatement.setString(5, appointment.getAppointmentId());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteAppointment(String appointmentId) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_APPOINTMENT_SQL)) {

            preparedStatement.setString(1, appointmentId);

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Appointment getAppointmentById(String appointmentId) throws SQLException {
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPOINTMENT_SQL)) {

            preparedStatement.setString(1, appointmentId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Appointment(
                            resultSet.getString("appointment_id"),
                            resultSet.getString("user_id"),
                            resultSet.getString("doctor_id"),
                            resultSet.getString("patient_id"),
                            resultSet.getTimestamp("appointment_datetime").toLocalDateTime()
                    );
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = ConManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPOINTMENTS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                appointments.add(new Appointment(
                        resultSet.getString("appointment_id"),
                        resultSet.getString("user_id"),
                        resultSet.getString("doctor_id"),
                        resultSet.getString("patient_id"),
                        resultSet.getTimestamp("appointment_datetime").toLocalDateTime()
                ));
            }
        }
        return appointments;
    }
}
