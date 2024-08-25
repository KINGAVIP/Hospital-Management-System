package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Appointment;
import com.hsbc.hospitalmanagement.domain.Doctor;
import com.hsbc.hospitalmanagement.exception.AppointmentCreationError;
import com.hsbc.hospitalmanagement.utils.ConManager;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    private static final String GET_SCHEDULE =
            """
                    SELECT * FROM SCHEDULE WHERE doctor_id = ?
                    """;

    private static final String ADD_APPOINTMENT = """
                INSERT INTO SCHEDULE (doctor_id, user, patient, datetime) VALUES (?, ?, ?, ?, ?)
            """;

    private static final String DELETE_APPOINTMENT = """
                DELETE FROM SCHEDULE WHERE doctor_id = ? AND datetime = ?
            """;

    public boolean addAppointment(Appointment appointment) throws AppointmentCreationError {

        try(Connection connection = ConManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SCHEDULE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String docId = resultSet.getString("doctor_id");
                String appointmentTime = resultSet.getString("dateTime");
                if(docId.equals(appointment.getDoctorId()) && appointmentTime.equals(appointment.getAppointmentDateTime().toString())) {
                    throw new AppointmentCreationError("Another appointment exists at this same time");
                }

                preparedStatement = connection.prepareStatement(ADD_APPOINTMENT);
                preparedStatement.setString(1, appointment.getDoctorId());
                preparedStatement.setString(2, appointment.getUserId());
                preparedStatement.setString(4, appointment.getPatientId());
                preparedStatement.setString(5, appointment.getAppointmentDateTime().toString());

                if (preparedStatement.executeUpdate() != 1) return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean deleteAppointment(String doctorId, String dateTime) {

        try (Connection connection = ConManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_APPOINTMENT);
            preparedStatement.setString(1, doctorId);
            preparedStatement.setString(2, dateTime);
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

    @Override
    public boolean updateAppointment(Appointment appointment) throws AppointmentCreationError {
        deleteAppointment(appointment.getDoctorId(), appointment.getAppointmentDateTime().toString());
        return addAppointment(appointment);
    }
}
