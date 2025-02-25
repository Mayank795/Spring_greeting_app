package com.Spring_greeting_app.service;

import com.Spring_greeting_app.GreetingRepository;
import com.Spring_greeting_app.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Find greeting by ID
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // Update a greeting by ID
    public Greeting updateGreeting(Long id, Greeting updatedGreeting) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(updatedGreeting.getMessage()); // Update the message
            return greetingRepository.save(greeting); // Save and return updated greeting
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }

    // Delete a greeting by ID
    public void deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }
}
