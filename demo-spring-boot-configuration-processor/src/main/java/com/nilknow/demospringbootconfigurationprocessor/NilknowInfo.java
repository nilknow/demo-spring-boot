package com.nilknow.demospringbootconfigurationprocessor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "nilknow")
@Configuration
@Setter
@Getter
public class NilknowInfo {
    private String name;
}
