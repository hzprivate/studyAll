package com.springboot.springbootehcache.dao;

import com.springboot.springbootehcache.beans.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author hz
 * @create 2020-04-08
 */
@Component
public interface UserDao {
    @Select("select * from user where uuid=#{uuid}")
    @Results(id = "user", value = { @Result(property = "uuid", column = "uuid", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class),
            @Result(property = "sex", column = "sex", javaType = String.class)})
    User getUserByUuid(String uuid);

    @Update("update user set name=#{name},password=#{password} where uuid=#{uuid}")
    int updateUserByuuid(User user);

    @Delete("delete from user where uuid=#{uuid}")
    void deleteUserByUuid(String uuid);
}
