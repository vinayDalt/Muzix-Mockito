package com.stackroute.MuzixApp.exception;

public class TrackNotFoundException extends Exception{

    public String message;

    public TrackNotFoundException(){

    }
    public TrackNotFoundException(String message){

        this.message=message;
    }

}
