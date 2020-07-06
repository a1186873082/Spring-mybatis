package org.lc.mybatis.configuration;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(Configuration1.class)
@ConditionalOnClass(Bean2.class)
public class Configuration2 {

    @Bean
    public Bean2 bean2(){
        System.out.println("我是Bean2");
        return new Bean2();
    }
}
