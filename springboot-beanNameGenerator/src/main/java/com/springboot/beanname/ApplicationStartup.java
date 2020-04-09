package com.springboot.beanname;

import com.springboot.beanname.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


//        //通过byType取Bean对象
//        UserService userService1 = event.getApplicationContext().getBean(UserService.class);
//        UserService userService2 = event.getApplicationContext().getBean(UserService.class);

        //通过byName取Bean对象
        UserService userService1 =(UserService) event.getApplicationContext().getBean("userService");
        UserService userService2 =(UserService) event.getApplicationContext().getBean("userService");

        //开始所有配置内容输出  测试单例多例
        System.out.println("userService1:"+userService1.hashCode());
        System.out.println("userService2:"+userService2.hashCode());
        userService1.testDemo();
        userService2.testDemo();


    }
}
