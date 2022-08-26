package com.nilknow.demospringbooth2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

@SpringBootApplication
public class DemoSpringBootH2Application implements CommandLineRunner {
    private final DemoService demoService;

    public DemoSpringBootH2Application(DemoService demoService) {
        this.demoService = demoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootH2Application.class, args);
    }

    @Override
    public void run(String... args) {
        testRequireNewWithEmpty();
    }

    public void testRequireNew() {
        try {
            demoService.demoMethod();
        } catch (Exception ignore) {
        }
        Assert.isTrue(demoService.getLoginUser("user_need_to_commit").isPresent(), "user_need_to_commit must be saved");
        Assert.isTrue(demoService.getLoginUser("user_need_to_rollback").isEmpty(), "user_need_to_rollback should not be saved");
    }

    public void testRequireNewWithEmpty() {
        try {
            demoService.demoEmptyMethod();
        } catch (Exception ignore) {
        }
        Assert.isTrue(demoService.getLoginUser("user_need_to_commit").isPresent(), "user_need_to_commit must be saved");
        Assert.isTrue(demoService.getLoginUser("user_need_to_rollback").isEmpty(), "user_need_to_rollback should not be saved");
    }
}
