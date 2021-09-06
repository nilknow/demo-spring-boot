package tech.poorguy.demospringbootweb.beanfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DemoBeanFactory {
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ConfigurableListableBeanFactory getBeanFactory(){
        return ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
    }

}
