package com.mydemo.aop.test;

import com.mydemo.aop.config.AspectJConfig;
import com.mydemo.aop.dao.TestDao;
import com.mydemo.aop.dao.TestDaoImpl;
import com.mydemo.aop.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hz
 * @Description:
 * @create 2020-04-25
 */
public class TestAppStart {
    public static void test1() throws IOException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AspectJConfig.class);
        UserDao userDao = (UserDao)annotationConfigApplicationContext.getBean(UserDao.class);
        Class<?>[] clazz = new Class[]{UserDao.class};
        byte[] hzDemos = ProxyGenerator.generateProxyClass("hzDemo", clazz);
        File file = new File("D:\\test\\test.class");
        FileOutputStream fom = null;
        try {
            fom = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fom != null) {
                fom.write(hzDemos);
            }
            fom.flush();
            fom.close();
        }
        userDao.getUserByUuid(1);
    }

    public static void test2() throws IOException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AspectJConfig.class);
        TestDao testDao = (TestDao)annotationConfigApplicationContext.getBean("testDao");
        System.out.println(testDao instanceof TestDaoImpl);
        Class<?>[] clazz = new Class[]{TestDao.class};
        byte[] hzDemos = ProxyGenerator.generateProxyClass("hzDemo1", clazz);
        File file = new File("D:\\test\\test.class");
        FileOutputStream fom = null;
        try {
            fom = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fom != null) {
                fom.write(hzDemos);
            }
            fom.flush();
            fom.close();
        }
        testDao.query();
    }

    public static void main(String[] args) throws IOException {
//        test1();
        test2();
    }

}
