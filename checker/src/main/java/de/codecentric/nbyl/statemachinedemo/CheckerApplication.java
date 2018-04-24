package de.codecentric.nbyl.statemachinedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckerApplication.class, args);
    }
}
