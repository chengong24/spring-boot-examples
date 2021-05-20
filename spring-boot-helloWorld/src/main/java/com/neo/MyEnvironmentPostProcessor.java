package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * @author: Chen Gong
 * @date：2021/4/25 10:18 上午
 */
@Order(value = Ordered.LOWEST_PRECEDENCE)
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        //MapPropertySource
        Properties properties = new Properties();
        properties.put("config.item.key", "value");
        PropertiesPropertySource source = new PropertiesPropertySource("custom", properties);
        environment.getPropertySources().addLast(source);
    }
}
