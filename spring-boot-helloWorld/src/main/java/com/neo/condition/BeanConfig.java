package com.neo.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chengong
 * @date 2020/7/29 5:33 下午
 */
@Configuration
public class BeanConfig {




    @Bean(name = "notebookPC")
    public Computer computer1(){
        return new Computer("笔记本电脑");
    }
}
