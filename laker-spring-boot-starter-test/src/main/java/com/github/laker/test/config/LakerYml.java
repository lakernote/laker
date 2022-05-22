package com.github.laker.test.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Objects;

//@Configuration
public class LakerYml {
    @Bean
    public static PropertySourcesPlaceholderConfigurer loadYaml() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        //如果在classpath下则这样写yaml.setResources(new ClassPathResource("config/diy.yml"));
        try {
            yaml.setResources(new ClassPathResource("laker.yml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        configurer.setProperties(Objects.requireNonNull(yaml.getObject()));
        return configurer;
    }
}