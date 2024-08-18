package com.hsbc.hospitalmanagement.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {

    User user;
    Doctor doctor;
    Patient patient;
    LocalDateTime appointmentDateTime;

    public Appointment(User user, Doctor doctor, Patient patient, LocalDateTime appointmentDateTime) {
        this.user = user;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDateTime = appointmentDateTime;
    }

    public User getUser() {
        return user;
    }

    // Equals and hashcode function uses only doctor object and appointment date-time
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment that)) return false;
        return Objects.equals(doctor, that.doctor) && Objects.equals(appointmentDateTime, that.appointmentDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, appointmentDateTime);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
}
