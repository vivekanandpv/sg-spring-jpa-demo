package com.vivekanandpv.jpademo.apis;

import com.vivekanandpv.jpademo.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationErrorHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException exception) {
        //  log
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler
    public ResponseEntity<?> handleOtherException(Throwable exception) {
        //  log
        System.out.println("Exception: " + exception.getMessage());
        return ResponseEntity.badRequest().build();
    }
}
