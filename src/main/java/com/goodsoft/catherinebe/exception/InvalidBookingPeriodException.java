package com.goodsoft.catherinebe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidBookingPeriodException extends RuntimeException {

    public InvalidBookingPeriodException() {
    }

    public InvalidBookingPeriodException(String message) {
        super(message);
    }

    public InvalidBookingPeriodException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBookingPeriodException(Throwable cause) {
        super(cause);
    }

    public InvalidBookingPeriodException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
