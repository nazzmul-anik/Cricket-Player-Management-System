package com.anik.cricket_app.exception;

import lombok.Data;

@Data
public class CricketAppServiceRuntimeException extends RuntimeException{
    private String errorCode;

    public CricketAppServiceRuntimeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
