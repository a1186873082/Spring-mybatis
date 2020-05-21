package org.lc.mybatis.service;

import org.lc.mybatis.mapper.OrderMapper;
import org.lc.mybatis.mapper.UserMapper;
import org.lc.mybatis.model.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    public List<String> test() {
        return userMapper.getById();
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertTest(TTest tTest) throws Exception{
        try {
            int id = userMapper.insertUser(tTest);
            tTest.setAge("20");
            updateTest(tTest);
        }catch (Exception e){
            throw new Exception(e);
        }
        return 1;
    }

    @Transactional
    public int updateTest(TTest tTest){
        userMapper.updateUser(tTest);
        int i = 1 / 0;
        return i;
    }
}
