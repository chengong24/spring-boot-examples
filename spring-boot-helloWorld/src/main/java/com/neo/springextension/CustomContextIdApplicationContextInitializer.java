package com.neo.springextension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * @author: Chen Gong
 * @date：2021/5/28 11:53 上午
 */
@Slf4j
@Component
public class CustomContextIdApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        Resource trantorConfigResource = configurableApplicationContext.getResource("classpath:custom-config.yml");
        List<PropertySource<?>> sources;
        try {
            sources = new YamlPropertySourceLoader().load("custom-config.yml", trantorConfigResource);
        } catch (IOException e) {
            log.error("", e);
            return;
        }
        configurableApplicationContext.getEnvironment().getPropertySources().addLast(sources.get(0));
        log.info("CustomContextIdApplicationContextInitializer1:{}", configurableApplicationContext.getEnvironment().getProperty("custom.name"));
        Properties properties = new Properties();
        properties.setProperty("custom.name", "custom name2");
        configurableApplicationContext.getEnvironment().getPropertySources().addFirst(new PropertiesPropertySource("this is a name", properties));
        log.info("CustomContextIdApplicationContextInitializer2:{}", configurableApplicationContext.getEnvironment().getProperty("custom.name"));
        properties.setProperty("custom.name", "custom name3");
        configurableApplicationContext.getEnvironment().getPropertySources().replace("this is a name", new PropertiesPropertySource("this is a name", properties));
        log.info("CustomContextIdApplicationContextInitializer3:{}", configurableApplicationContext.getEnvironment().getProperty("custom.name"));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
