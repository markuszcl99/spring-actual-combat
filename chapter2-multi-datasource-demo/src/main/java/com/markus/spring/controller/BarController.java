package com.markus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: markus
 * @date: 2022/12/23 11:20 PM
 * @Description: 操作Bar数据源
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@RequestMapping("/bar")
@RestController
public class BarController {

    @Autowired
    private JdbcTemplate barJdbcTemplate;

    @PostMapping("/create-datasource")
    public Object createDataSource() {
        barJdbcTemplate.execute("CREATE TABLE BAR ID INT IDENTITY, BAR VARCHAR(64));");
        return "SUCCESS";
    }

    @PostMapping("/insert-hello")
    public Object insertHello() {
        barJdbcTemplate.execute("INSERT INTO BAR (ID, BAR) VALUES (1, 'hello');");
        return "SUCCESS";
    }

    @GetMapping("/get-info")
    public Object getInfo() {
        return barJdbcTemplate.queryForList("SELECT * FROM FOO");
    }
}
