package com.markus.spring.errorcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: markus
 * @date: 2022/12/24 5:57 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorCodeDemoApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test(expected = CustomDuplicatedKeyException.class)
    public void testThrowingCustomException() {
        jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'a')");
        jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'b')");
    }
}
