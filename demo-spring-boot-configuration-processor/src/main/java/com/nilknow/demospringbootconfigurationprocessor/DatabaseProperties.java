package com.nilknow.demospringbootconfigurationprocessor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database")
@Getter
@Setter
public class DatabaseProperties {

    @Getter
    @Setter
    public static class Server {
        private String ip;
        private int port;
    }
	
    private String username;
    private String password;
    private Server server;
	
}