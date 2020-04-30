package com.springboot.globalexception.test;

import com.springboot.globalexception.bean.ResponseEnum;
import com.springboot.globalexception.bean.User;
import com.springboot.globalexception.dao.UserDao;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author hz
 * @create 2020-04-30
 */
public class DemoTest {
    @Test
    public void test1(){
        UserDao userDao = new UserDao();
        User user = userDao.getUserById("123");
        Assert.notNull(user, "用户不存在.");
        //equals
//        if (user == null) {
//            throw new IllegalArgumentException("用户不存在.");
//        }
    }
    @Test
    public void test2(){
        System.out.println(ResponseEnum.BAD_USER_TYPE.getCode());
    }

}
