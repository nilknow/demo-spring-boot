package tech.poorguy.demospringbootscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoSpringBootSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootSchedulingApplication.class, args);
    }

}
