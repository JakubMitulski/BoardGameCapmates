package com.capgemini.boardgames.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NoSuchUserException.class})
    public ResponseEntity<Object> handleUserException() {
        return ResponseEntity.badRequest().body("No such user in db or invalid user id");
    }

    @ExceptionHandler({NoSuchGameNameException.class})
    public ResponseEntity<Object> handleGameNameException() {
        return ResponseEntity.badRequest().body("No such game in db this given name");
    }

    @ExceptionHandler({NoSuchGameMaxPlayerException.class})
    public ResponseEntity<Object> handleGameMaxPlayerException() {
        return ResponseEntity.badRequest().body("No such game in db with this maxPlayerNumber");
    }

    @ExceptionHandler({NoSuchGameMinPlayerException.class})
    public ResponseEntity<Object> handleGameMinPlayerException() {
        return ResponseEntity.badRequest().body("No such game in db with this minPlayerNumber");
    }

    @ExceptionHandler({NoSuchGameSubscribersException.class})
    public ResponseEntity<Object> handleGameSubscribersException() {
        return ResponseEntity.badRequest().body("No such game in db with these subscribers");
    }

}
