package com.anik.cricket_app.exception;

import com.anik.cricket_app.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CricketAppServiceRuntimeException.class)
    public ResponseEntity<ErrorResponse> handleCricketAppServiceException(CricketAppServiceRuntimeException exception){
        ErrorResponse errorResponse
                = ErrorResponse.builder()
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
