package com.springboot.springbootehcache.service;

import com.springboot.springbootehcache.beans.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author hz
 * @create 2020-04-08
 */
@CacheConfig(cacheNames = "user")
public interface UserService {
    //* @Cacheable : Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，
    // 如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，
    // 否则才会执行并将返回结果存入指定的缓存中。

    //* @CacheEvict : 清除缓存。

    //* @CachePut : @CachePut也可以声明一个方法支持缓存功能。
    // 使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
    // 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
    @CachePut(key = "#p0.uuid")
    User updateUserByuuid(User user);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteUserByUuid(String uuid);

    @Cacheable(key = "#p0")
    User getUserByUuid(String uuid);

}
