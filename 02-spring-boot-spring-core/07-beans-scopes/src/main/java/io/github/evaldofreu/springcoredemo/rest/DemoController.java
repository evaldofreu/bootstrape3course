package io.github.evaldofreu.springcoredemo.rest;

import io.github.evaldofreu.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public void setCoach(@Qualifier("cricketCoach") Coach theCoach,@Qualifier("cricketCoach") Coach theAnotherCoach){
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }


    public DemoController(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing Beans: myCoach == anotherCoach, "+(myCoach==anotherCoach);
    }

}
