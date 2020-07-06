package org.lc.mybatis.configuration;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(Configuration2.class)
@ConditionalOnClass(Bean1.class)
public class Configuration1 {

    @Bean
    @ConditionalOnBean(Bean2.class)
    public Bean1 bean1(){
        System.out.println("我是Bean1");
        return new Bean1();
    }
}
