package com.lab.fundamentals.customexception;

/** Checked exception — invalid HRMS employee identity. */
public class InvalidEmployeeException extends Exception {

    public InvalidEmployeeException(String message) {
        super(message);
    }

    public InvalidEmployeeException(String message, Throwable cause) {
        super(message, cause);
    }
}
