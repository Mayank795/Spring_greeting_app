package com.Spring_greeting_app.service;

import com.Spring_greeting_app.GreetingRepository;
import com.Spring_greeting_app.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    private GreetingRepository greetingRepository;
    // Default greeting
    public Greeting getSimpleGreeting() {
        Greeting greeting = new Greeting("Hello World");
        return greetingRepository.save(greeting); // Save to repository
    }

    // Greeting with full name
    public Greeting getGreetingWithFullName(String firstName, String lastName) {
        Greeting greeting = new Greeting("Hello " + firstName + " " + lastName);
        return greetingRepository.save(greeting); // Save to repository
    }
}
