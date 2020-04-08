package com.springboot.springbootehcache.service.serviceImpl;

import com.springboot.springbootehcache.beans.User;
import com.springboot.springbootehcache.dao.UserDao;
import com.springboot.springbootehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hz
 * @create 2020-04-08
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User updateUserByuuid(User user) {
         userDao.updateUserByuuid(user);
        //放入缓存
        return this.userDao.getUserByUuid(user.getUuid());
    }

    @Override
    public void deleteUserByUuid(String uuid) {
        userDao.deleteUserByUuid(uuid);
    }

    @Override
    public User getUserByUuid(String uuid) {
        return userDao.getUserByUuid(uuid);
    }
}
