package com.springboot.beanname.service.serviceImpl;

import com.springboot.beanname.dao.UserDao;
import com.springboot.beanname.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author hz
 * @create 2020-04-09
 */
@Service
//@Scope("prototype")
public class UserServiceImpl implements UserService {
//    @Resource(name = "userDao2")
//    UserDao userDao;

    @Autowired
    @Qualifier("userDao2Impl")
    UserDao userDao;


    @Override
    public void testDemo() {
//        System.out.println(userDao.getClass().getName()+"，"+userDao.hashCode());
    }
}
