package io.github.evaldofreu.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;



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


    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+coachName+", TeamName: "+teamName;
    }
}

