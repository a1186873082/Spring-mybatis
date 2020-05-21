package org.lc.mybatis.mapper;

import org.lc.mybatis.model.TTest;

import java.util.List;

public interface UserMapper {
    List<String> getById();

    int insertUser(TTest tTest);

    int updateUser(TTest tTest);
}
