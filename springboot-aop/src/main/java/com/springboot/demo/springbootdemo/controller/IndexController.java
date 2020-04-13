package com.springboot.demo.springbootdemo.controller;

import com.springboot.demo.springbootdemo.annotation.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> </p>
 *
 * @author hz
 * @create 2020-04-08
 */
@RestController
public class IndexController {
    @Log("测试静态变量")
    @RequestMapping("/one")
    public void methodOne() {
        System.out.println("业务方法本身");
    }

}
