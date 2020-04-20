package com.maven.mybatis.test;

import com.maven.mybatis.dao.CourseDao;
import com.maven.mybatis.dataSource.MybatisConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hz
 * @Description:
 * @create 2020-04-17
 */
public class start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MybatisConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        CourseDao courseDao =(CourseDao) annotationConfigApplicationContext.getBean("courseDao");
        courseDao.deleteCourse("c001");
        System.out.println("删除完成");


    }
}
