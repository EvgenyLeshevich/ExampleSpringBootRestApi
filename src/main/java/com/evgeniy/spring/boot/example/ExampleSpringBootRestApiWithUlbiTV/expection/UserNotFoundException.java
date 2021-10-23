package com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.expection;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
