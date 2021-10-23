package com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.expection;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
