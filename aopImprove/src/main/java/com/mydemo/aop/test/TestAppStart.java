package com.mydemo.aop.test;

import com.mydemo.aop.config.AspectJConfig;
import com.mydemo.aop.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hz
 * @Description:
 * @create 2020-04-25
 */
public class TestAppStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AspectJConfig.class);
        UserDao userDao = (UserDao)annotationConfigApplicationContext.getBean(UserDao.class);
        userDao.getUserByUuid(1);
    }

}
