package com.Spring_greeting_app.Controller;

import com.Spring_greeting_app.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class greetingController {
@GetMapping()
    public Greeting getGreeting(){
    return new Greeting("hello from bridgelab");
}
}
