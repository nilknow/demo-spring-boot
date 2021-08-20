package tech.poorguy.demospringcloudtasksimple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class DemoSpringCloudTaskSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudTaskSimpleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("this is simple springCloudTaskApp");
            }
        };
    }
}
