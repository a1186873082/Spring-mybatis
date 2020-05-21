package org.lc.mybatis;

import org.lc.mybatis.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService userService = (UserService) context.getBean("userService");
//        System.out.println(userService.test());
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
}
