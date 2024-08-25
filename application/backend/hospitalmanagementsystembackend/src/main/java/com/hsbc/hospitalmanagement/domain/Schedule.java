package com.hsbc.hospitalmanagement.domain;

import java.util.List;
import java.util.Objects;

public class Schedule {

    private String doctorId;
    private List<Appointment> appointments;

    public String getDoctorId() {
        return doctorId;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Schedule(String doctorId, List<Appointment> appointments) {
        this.doctorId = doctorId;
        this.appointments = appointments;
    }

    public Schedule(String doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule schedule)) return false;
        return Objects.equals(doctorId, schedule.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(doctorId);
    }
}
