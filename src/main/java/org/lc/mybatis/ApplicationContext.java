package org.lc.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.lc.mybatis.scan.LcScan;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@ImportResource({"applicationContext.xml"})
@Configuration
public class ApplicationContext {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationContext.class, args);
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
