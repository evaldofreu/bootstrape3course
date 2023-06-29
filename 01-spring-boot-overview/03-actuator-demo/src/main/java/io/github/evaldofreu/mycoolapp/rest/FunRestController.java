package io.github.evaldofreu.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
       return "Hello World!";
    }

    @GetMapping("/workout")
    public String workout(){
        return "Ride a bike for 2 hours!";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String fortune(){
        return "Today is your lucky day!";
    }

}

