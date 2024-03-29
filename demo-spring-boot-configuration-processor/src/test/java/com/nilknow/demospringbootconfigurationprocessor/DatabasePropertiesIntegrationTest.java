package com.nilknow.demospringbootconfigurationprocessor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSpringBootConfigurationProcessorApplication.class)
@TestPropertySource("classpath:databaseproperties-test.properties")
public class DatabasePropertiesIntegrationTest {
    @Autowired
    private DatabaseProperties databaseProperties;

    @Test
    public void whenSimplePropertyQueriedThenReturnsPropertyValue() {
        Assert.assertEquals("Incorrectly bound Username property",
          "username", databaseProperties.getUsername());
        Assert.assertEquals("Incorrectly bound Password property", 
          "password", databaseProperties.getPassword());
    }

    @Test
    public void whenNestedPropertyQueriedThenReturnsPropertyValue() {
        Assert.assertEquals("Incorrectly bound Server IP nested property",
                "127.0.0.1", databaseProperties.getServer().getIp());
        Assert.assertEquals("Incorrectly bound Server Port nested property",
                3306, databaseProperties.getServer().getPort());
    }
}