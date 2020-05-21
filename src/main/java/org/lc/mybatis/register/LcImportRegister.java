package org.lc.mybatis.register;

import org.lc.mybatis.factoryBean.LcFactoryBean;
import org.lc.mybatis.mapper.OrderMapper;
import org.lc.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class LcImportRegister implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        List<Class> mappers = new ArrayList();
        mappers.add(UserMapper.class);
        mappers.add(OrderMapper.class);

        for (Class mapper : mappers) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionBuilder.getBeanDefinition();
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);
            beanDefinition.setBeanClass(LcFactoryBean.class);
            beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
            beanDefinitionRegistry.registerBeanDefinition(mapper.getSimpleName(), beanDefinition);
        }
    }
}
