package com.markus.spring.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @author: markus
 * @date: 2022/12/24 10:51 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Slf4j
public class GreetingApplicationRunner implements ApplicationRunner {

    public GreetingApplicationRunner(){
        log.info("Initializing GreetingApplicationRunner.");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Hello everyone! We all like Spring!");
    }
}
