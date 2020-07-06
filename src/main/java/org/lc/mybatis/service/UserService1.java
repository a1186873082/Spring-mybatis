package org.lc.mybatis.service;

import org.lc.mybatis.mapper.UserMapper;
import org.lc.mybatis.model.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionStatus;

@Service
public class UserService1 {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.NESTED)
    public int insertTwo(TTest tTest){
        tTest.setAge("25");
        userMapper.insertUser(tTest);
        if("lc".equals(tTest.getName())){
            throw new RuntimeException();
        }
        return 1;
    }
}
