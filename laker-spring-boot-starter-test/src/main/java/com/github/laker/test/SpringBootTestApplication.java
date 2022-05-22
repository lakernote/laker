
package com.github.laker.test;


import com.github.laker.test.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@SpringBootApplication
@Slf4j
public class SpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);

    }

    @Component
    public class LakerHandler implements CommandLineRunner {
        @Autowired
        Environment env;
        @Autowired
        TestConfig config;
        @Value("${laker.username}")
        private String username;

        @Override
        public void run(String... args) {
            log.info(config.toString());
            log.info(username);
            log.info(env.getProperty("laker.username"));
        }
    }

}