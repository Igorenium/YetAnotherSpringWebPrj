package ru.kartashov;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.kartashov")
@PropertySource("classpath:SpringWebApp.properties")
public class Config {
}