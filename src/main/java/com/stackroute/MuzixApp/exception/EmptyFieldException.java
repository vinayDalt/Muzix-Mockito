package com.stackroute.MuzixApp.exception;

public class EmptyFieldException extends Exception{

    public String message;

    public EmptyFieldException(){}

    public EmptyFieldException(String message){


        super(message);
        this.message=message;
    }
}
