package com.markus.spring.custom.starter;

import com.markus.spring.greeting.GreetingApplicationRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author: markus
 * @date: 2022/12/24 11:03 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@SpringBootApplication
@Slf4j
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

    @Bean
    public GreetingApplicationRunner greetingApplicationRunner(){
        log.info("from manual operation register GreetingApplicationRunner Bean");
        return new GreetingApplicationRunner();
    }
}
