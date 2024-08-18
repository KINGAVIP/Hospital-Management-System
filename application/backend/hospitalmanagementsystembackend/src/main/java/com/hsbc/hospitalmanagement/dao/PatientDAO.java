package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Patient;

import java.sql.SQLException;

public interface PatientDAO {
    void registerPatient(Patient patient) throws SQLException;
    Patient getPatientDetails(String patientId) throws SQLException;
    void updatePatient(Patient patient) throws SQLException;
}
