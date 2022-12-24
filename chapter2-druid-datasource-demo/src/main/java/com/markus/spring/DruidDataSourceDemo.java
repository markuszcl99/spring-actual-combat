package com.markus.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

/**
 * @author: markus
 * @date: 2022/12/24 11:05 AM
 * @Description: Spring配置Druid数据库连接池示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@SpringBootApplication
@Slf4j
public class DruidDataSourceDemo implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DruidDataSourceDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(dataSource.toString());
    }

    /**
     * Druid实用的功能
     *   - 详细的监控
     *   - ExceptionSorter，针对主流数据库的返回都有支持
     *   - SQL防注入
     *   - 内置加密配置
     *   - 众多扩展点，方便进行定制
     */

    /**
     * 选择连接池时需要考量的点
     *   - 可靠性
     *   - 性能
     *   - 功能
     *   - 可运维性
     *   - 可扩展性
     *   - 其他 例如社区活跃度等等
     */
}
