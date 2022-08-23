package com.nilknow.demospringcloudtask;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
//@EnableBatchProcessing
public class DemoSpringCloudTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudTaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new HelloWorldCommandLineRunner();
    }

    public static class HelloWorldCommandLineRunner implements CommandLineRunner {
        @Override
        public void run(String... args) throws InterruptedException {
            System.out.println("hello world start...");
            Thread.sleep(3*1000);
            System.out.println("hello world");
            Thread.sleep(3*1000);
            System.out.println("hello world end...");
        }
    }
}
