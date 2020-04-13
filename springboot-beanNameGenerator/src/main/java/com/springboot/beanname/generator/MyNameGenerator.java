package com.springboot.beanname.generator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * 自定义 组件命名规则
 * @author hz
 * @create 2020-04-09
 */
public class MyNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {

            //获取全限定名称
            String beanClassName = beanDefinition.getBeanClassName();
//        //获取类名
//        String shortClassName = ClassUtils.getShortName(beanClassName);
            //小写首字母
//        String decapitalize = Introspector.decapitalize(shortClassName);
            return beanClassName;


    }
}
