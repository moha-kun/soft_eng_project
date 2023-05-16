package org.moha.miniproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionMessage> handleException(Exception e) {
        return new ResponseEntity<>(ExceptionMessage.builder()
                .message(e.getMessage())
                .date(LocalDate.now())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
