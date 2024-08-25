package com.hsbc.hospitalmanagement.exception;

public class AppointmentCreationError extends Exception{
    public AppointmentCreationError() {
    }

    public AppointmentCreationError(String message) {
        super(message);
    }

    public AppointmentCreationError(String message, Throwable cause) {
        super(message, cause);
    }

    public AppointmentCreationError(Throwable cause) {
        super(cause);
    }

    public AppointmentCreationError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
