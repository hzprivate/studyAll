package com.springboot.springbootehcache.test;


import com.springboot.springbootehcache.beans.User;
import com.springboot.springbootehcache.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hz
 * @since 2019/9/25 14:11
 */
public class Demo extends TestConf {

    private Logger logger = LoggerFactory.getLogger(Demo.class);
    @Autowired
    UserService userService;

    /**
     * 查询 缓存
     * @throws Exception
     */
    @Test
    public  void test1()  throws  Exception{
        //第一次查询数据库，放入缓存
        User user1 = userService.getUserByUuid("3");
        System.out.println("用户姓名为：" + user1.getName());

        //第二次查询缓存
        User user2 = userService.getUserByUuid("3");
        System.out.println("用户姓名为：" + user2.getName());


    }

    /**
     * 更新缓存
     * @throws Exception
     */
    @Test
    public  void test2()  throws  Exception{
        User user = User.builder().name("test1").sex("女").uuid("3").build();

        //查询数据库，更新缓存
        userService.updateUserByuuid(user);

        //直接查缓存，不查数据库
        User user2 = userService.getUserByUuid("3");
        System.out.println("用户姓名为：" + user2.getName());


    }



}
