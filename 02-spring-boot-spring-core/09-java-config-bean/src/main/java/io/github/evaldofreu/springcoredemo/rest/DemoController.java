package io.github.evaldofreu.springcoredemo.rest;

import io.github.evaldofreu.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;


    @Autowired
    public void setCoach(@Qualifier("aquatic") Coach theCoach){
        System.out.println("In constructor: "+getClass().getSimpleName());
        myCoach = theCoach;

    }


    public DemoController(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


}
