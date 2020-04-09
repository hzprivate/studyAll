package com.springboot.springbootehcache.controller;

import com.springboot.springbootehcache.beans.User;
import com.springboot.springbootehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hz
 * @create 2020-04-08
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/one")
    public void methodOne() {
        User user1 = this.userService.getUserByUuid("1");
        System.out.println("用户姓名为：" + user1.getName());

        User user2 = this.userService.getUserByUuid("1");
        System.out.println("用户姓名为：" + user2.getName());
    }

}
