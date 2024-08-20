package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.utils.ConManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    private static final String GET_SCHEDULE =
            """
                    SELECT * FROM SCHEDULE WHERE doctor_id = ?
                    """;

    private static final String ADD_APPOINTMENT = """
                INSERT INTO SCHEDULE (doctor_id, user, doctor, patient, datetime) VALUES (?, ?, ?, ?, ?)
            """;

    private static final String DELETE_APPOINTMENT = """
                DELETE FROM SCHEDULE WHERE doctor_id = ?
            """;

    public boolean addAppointment(Appointment appointment) {

        try(Connection connection = ConManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_APPOINTMENT);
            preparedStatement.setString(1, appointment.getDoctor().getId());
            preparedStatement.setString(2, appointment.getUser().getName());
            preparedStatement.setString(3, appointment.getDoctor().getName());
            preparedStatement.setString(4, appointment.getPatient().getName());
            preparedStatement.setString(5, appointment.getAppointmentDateTime().toString());

            if (preparedStatement.executeUpdate() != 1) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean deleteAppointment(Appointment appointment) {

        try (Connection connection = ConManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_APPOINTMENT);
            preparedStatement.setString(1, appointment.getDoctor().getId());
            if (preparedStatement.executeUpdate() != 1) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

        public List<String> getAllAppointments(String doctorId) {

            try(Connection connection = ConManager.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(GET_SCHEDULE);
                preparedStatement.setString(1, doctorId);

                List<String> resultList = new ArrayList<>();
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        resultList.add(resultSet.getString(1) + " - " +
                                resultSet.getString(2) + " - " +
                                resultSet.getString(3) + " - " +
                                resultSet.getString(4) + " - " +
                                resultSet.getString(5) + " - ");
                    } else {
                        return null;
                    }
                }
                return resultList;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
