package tech.poorguy.demospringbootweb.beanfactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoBeanFactoryIntegrationTest {
    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    @Test
    void test(){
        then(beanFactory).isNotNull();
    }
}