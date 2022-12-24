package com.markus.spring.autoconfigure;

import com.markus.spring.greeting.GreetingApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: markus
 * @date: 2022/12/24 10:49 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Configuration
@ConditionalOnClass({GreetingApplicationRunner.class})
public class MarkusSpringAutoConfiguration {

    @Bean // 标记为Bean
    @ConditionalOnMissingBean(GreetingApplicationRunner.class) // 在容器中没有GreetingApplicationRunner Bean生效
    @ConditionalOnProperty(name = "greeting.enable", havingValue = "true", matchIfMissing = true) // 在配置文件中配置greeting.enable = true 或者没有该配置时生效
    public GreetingApplicationRunner greetingApplicationRunner() {
        return new GreetingApplicationRunner();
    }

}
