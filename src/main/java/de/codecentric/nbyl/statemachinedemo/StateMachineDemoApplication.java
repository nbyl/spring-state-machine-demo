package de.codecentric.nbyl.statemachinedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StateMachineDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StateMachineDemoApplication.class, args);
    }
}
