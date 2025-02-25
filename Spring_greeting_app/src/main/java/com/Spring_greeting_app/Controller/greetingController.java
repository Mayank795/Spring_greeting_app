package com.Spring_greeting_app.Controller;

import com.Spring_greeting_app.model.Greeting;
import com.Spring_greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")

public class greetingController {
    @Autowired
    private GreetingService greetingService;   // Inject the service
//UC1
    @GetMapping()
    public Greeting getGreeting(){
        return new Greeting("hello from bridgelab");
    }

 //UC2
    // Add a new endpoint to use the service layer
    @GetMapping("/simple")
    public Greeting getSimpleGreeting() {
        String message = greetingService.getSimpleGreeting();
        return new Greeting(message);
    }

 //UC3
 // New endpoint for greeting with full name
 @PostMapping("/fullname")
 public Greeting getGreetingWithFullName(@RequestParam String firstName, @RequestParam String lastName) {
     String message = greetingService.getGreetingWithFullName(firstName, lastName);
     return new Greeting(message);
 }

}

