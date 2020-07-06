package org.lc.mybatis.service;

import org.lc.mybatis.mapper.OrderMapper;
import org.lc.mybatis.mapper.UserMapper;
import org.lc.mybatis.model.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionStatus;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserService1 userService1;

    public List<String> test() {
        return userMapper.getById();
    }

    @Transactional
    public int insertTest(TTest tTest) {
        int id = userMapper.insertUser(tTest);
        DefaultTransactionStatus transactionStatus = (DefaultTransactionStatus) TransactionAspectSupport.currentTransactionStatus();
        transactionStatus.createAndHoldSavepoint();
        userService1.insertTwo(tTest);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        return id;
    }
}
