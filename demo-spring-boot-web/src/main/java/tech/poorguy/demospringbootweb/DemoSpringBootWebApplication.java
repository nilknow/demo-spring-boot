package tech.poorguy.demospringbootweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

@SpringBootApplication
public class DemoSpringBootWebApplication {

    public static void main(String[] args) {
        new ObjectMapper().writeValue();
        SpringApplication.run(DemoSpringBootWebApplication.class, args);
    }

}
