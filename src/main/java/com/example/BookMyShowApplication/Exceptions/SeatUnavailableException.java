package com.example.BookMyShowApplication.Exceptions;

public class SeatUnavailableException extends Exception{
    public SeatUnavailableException(String message){
        super(message);
    }
}
