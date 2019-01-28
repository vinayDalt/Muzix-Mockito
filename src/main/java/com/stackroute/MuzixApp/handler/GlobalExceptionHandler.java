package com.stackroute.MuzixApp.handler;


import com.stackroute.MuzixApp.exception.EmptyFieldException;
import com.stackroute.MuzixApp.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Not all mandatory fields are filled")
    @ExceptionHandler(EmptyFieldException.class)
    public void handleEmptyFieldException(EmptyFieldException e){
       System.out.println("Not all mandatory fields are filled"+ e);
    }

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="User already exists")
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public void handleUserAlreadyExistsException(TrackAlreadyExistsException e){
        System.out.println("User already exists"+ e);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User does not exist")
    @ExceptionHandler(TrackNotFoundException.class)
    public void handleUserDoesNotExistException(TrackNotFoundException e){
        System.out.println("User does not exist" +e);
    }



}
