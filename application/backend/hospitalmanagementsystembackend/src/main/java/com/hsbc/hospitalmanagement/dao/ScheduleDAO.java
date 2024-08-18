package com.hsbc.hospitalmanagement.dao;

import com.hsbc.hospitalmanagement.domain.Appointment;

public class ScheduleDAO {

    private static final String GET_SCHEDULE =
            """
                    SELECT * FROM SCHEDULE WHERE DOCTOR_ID = ?
                    """;

    private static final String ADD_SCHEDULE = """
                INSERT INTO SCHEDULE VALUES (?, ?, ?, ?, ?)
            """;

    public void addAppointment(Appointment appointment) {
        
    }
}
