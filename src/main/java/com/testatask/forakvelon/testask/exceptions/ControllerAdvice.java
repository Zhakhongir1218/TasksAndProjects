package com.testatask.forakvelon.testask.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProjectIsNullException.class)
    public ResponseEntity<?> handleAlreadyExist(ProjectIsNullException projectIsNullException) {
        return new ResponseEntity<>(new ResponseException(projectIsNullException.getTitle(), projectIsNullException.getMessage()), HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(TaskIsNullExeption.class)
    public ResponseEntity<?> handleAlreadyExist(TaskIsNullExeption taskIsNullExeption) {
        return new ResponseEntity<>(new ResponseException(taskIsNullExeption.getTitle(), taskIsNullExeption.getMessage()), HttpStatus.NOT_FOUND);
    }

}

