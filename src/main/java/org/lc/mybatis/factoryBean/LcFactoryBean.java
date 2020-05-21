package org.lc.mybatis.factoryBean;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.FactoryBean;

public class LcFactoryBean extends SqlSessionDaoSupport implements FactoryBean {
    public Class mapperInstence;

    public LcFactoryBean(Class mapperInstence) {
        this.mapperInstence = mapperInstence;
    }

    public Object getObject() throws Exception {

        return getSqlSession().getMapper(mapperInstence);
    }

    public Class<?> getObjectType() {
        return mapperInstence;
    }
}
