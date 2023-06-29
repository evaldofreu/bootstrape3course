package io.github.evaldofreu.springcoredemo.config;

import io.github.evaldofreu.springcoredemo.common.Coach;
import io.github.evaldofreu.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
