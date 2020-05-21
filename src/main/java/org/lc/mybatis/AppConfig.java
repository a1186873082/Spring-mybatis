//package org.lc.mybatis;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.zaxxer.hikari.HikariDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.lc.mybatis.scan.LcScan;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.env.ConfigurablePropertyResolver;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//
//
//@LcScan("org.lc.mybatis.mapper")
////@MapperScan("org.lc.mybatis.mapper")
//@ComponentScan("org.lc.mybatis")
//@PropertySource(value = {"classpath:jdbc.properties"})
//@Configuration
//public class AppConfig {
//
//    @Bean
//    @Order(1)
//    public DataSource dataSource(
//            @Value("${driver}") String driver,
//            @Value("${url}") String url,
//            @Value("${name}") String username,
//            @Value("${password}") String password){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext context) throws IOException {
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource((DataSource) context.getBean("dataSource"));
//        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        return sqlSessionFactory;
//    }
//}
