package com.rosyoki.spring.boot.sample.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 */
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:applicationContext.xml")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
