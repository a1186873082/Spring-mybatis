package org.lc.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.lc.mybatis.configuration.Configuration1;
import org.lc.mybatis.configuration.Configuration2;
import org.lc.mybatis.scan.LcScan;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@SpringBootApplication
@LcScan("org.lc.mybatis.mapper")
//@MapperScan("org.lc.mybatis.mapper")
@ComponentScan("org.lc.mybatis")
@PropertySource(value = {"classpath:jdbc.properties"})
//@ImportResource({"applicationContext.xml"})
@Configuration
public class LxApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(LxApplicationContext.class, args);
        System.out.println(applicationContext.getBean("bean2"));
        System.out.println(applicationContext.getBean("bean1"));
    }



    @Bean
    @Order(1)
    public DataSource dataSource(
            @Value("${driver}") String driver,
            @Value("${url}") String url,
            @Value("${name}") String username,
            @Value("${password}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(org.springframework.context.ApplicationContext context) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource((DataSource) context.getBean("dataSource"));
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactory;
    }
}
