package com.markus.spring.filter;


import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @author: markus
 * @date: 2022/12/24 11:17 AM
 * @Description: Druid 定制扩展
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Slf4j
public class DruidFilterDemo extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("BEFORE CONNECTION!");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("AFTER CONNECTION!");
    }
}
