package org.lc.mybatis.mapper;

import java.util.List;

public interface UserMapper {
    List<String> getById();

    int insertUser();
}
