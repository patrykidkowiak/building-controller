package com.building.controller.aop;

import com.building.controller.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationErrorHandler {

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity handleNumberFormatException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity handleEmailAlreadyRegisteredException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(ApplicationUserNotFoundException.class)
    public ResponseEntity handleApplicationUserNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ApplicationUserIsActiveException.class)
    public ResponseEntity handleApplicationUserIsActiveException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(RegisterFailureException.class)
    public ResponseEntity handleApplicationRegisterFailureExceptionException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(HomeNotFoundException.class)
    public ResponseEntity handleHomeNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity handleRoomNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BulbNotFoundException.class)
    public ResponseEntity handleBulbNotFoundException() {
        return ResponseEntity.notFound().build();
    }
}
