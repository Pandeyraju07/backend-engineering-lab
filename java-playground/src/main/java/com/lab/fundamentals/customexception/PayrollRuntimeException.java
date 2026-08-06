package com.lab.fundamentals.customexception;

/** Unchecked exception — payroll calculation / net-pay guard failures. */
public class PayrollRuntimeException extends RuntimeException {

    public PayrollRuntimeException(String message) {
        super(message);
    }

    public PayrollRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
