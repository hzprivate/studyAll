package com.mydemo.aop.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author hz
 * @create 2020-04-08
 */
@Component
public class UserDao{
    public void getUserByUuid(Integer a) {
        System.out.println("getUserByUuid"+a);
    }
}
