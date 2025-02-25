package com.Spring_greeting_app.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getSimpleGreeting() {
        return "Hello World";
    }

    public String getGreetingWithFullName(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }
}
