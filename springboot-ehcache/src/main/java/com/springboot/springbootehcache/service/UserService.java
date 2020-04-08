package com.springboot.springbootehcache.service;

import com.springboot.springbootehcache.beans.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author hz
 * @create 2020-04-08
 */
public interface UserService {
    @CachePut(key = "#p0.sno")
    User updateUserByuuid(User user);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteUserByUuid(String sno);

    @Cacheable(key = "#p0")
    User getUserByUuid(String sno);

}
