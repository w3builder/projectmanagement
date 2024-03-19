package com.project.management.exceptions.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.management.exceptions.BusinessException;
import com.project.management.exceptions.ConflictException;
import com.project.management.exceptions.UnprocessableEntityException;

@ControllerAdvice(basePackages = "com.project.management.controllers.rest")
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handlerBusinessException(BusinessException ex, HttpServletRequest request) {
        return response(ex.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ErrorResponse> handlerUnprocessableEntity(UnprocessableEntityException ex, HttpServletRequest request) {
        return response(ex.getMessage(), request, HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now());
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handlerConflictException(ConflictException ex, HttpServletRequest request) {
        return response(ex.getMessage(), request, HttpStatus.CONFLICT, LocalDateTime.now());
    }

    private ResponseEntity<ErrorResponse> response(final String message, final HttpServletRequest request, final HttpStatus status, LocalDateTime date) {
        return ResponseEntity
                .status(status)
                .body(new ErrorResponse(message, dateFormate(date), status.value(), request.getRequestURI()));
    }
    
    private String dateFormate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        return date.format(formatter);
    }
}
