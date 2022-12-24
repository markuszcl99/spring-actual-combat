package com.markus.spring.tx.declararive;

import com.markus.spring.tx.declararive.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: markus
 * @date: 2022/12/24 5:07 PM
 * @Description: 声明式事务
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@SpringBootApplication
@EnableTransactionManagement
@Slf4j
public class DeclarativeTransactionDemoApplication implements CommandLineRunner {

    @Autowired
    private FooService fooService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DeclarativeTransactionDemoApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        fooService.insertRecord();
        // 结果 AAA {1}
        log.info("AAA {}",
                jdbcTemplate
                        .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));
        try {
            fooService.insertThenRollback();
        } catch (Exception e) {
            // 结果 BBB {0}
            log.info("BBB {}",
                    jdbcTemplate
                            .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
        }

        try {
            fooService.invokeInsertThenRollback();
        } catch (Exception e) {
            // 结果 BBB {1}
            log.info("BBB {}",
                    jdbcTemplate
                            .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
        }
    }
}
