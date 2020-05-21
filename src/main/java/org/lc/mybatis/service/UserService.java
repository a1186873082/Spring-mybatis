package org.lc.mybatis.service;

import org.lc.mybatis.mapper.OrderMapper;
import org.lc.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    public List<String> test(){
        return userMapper.getById();
    }

    public int insertTest(){
        return userMapper.insertUser();
    }
}
