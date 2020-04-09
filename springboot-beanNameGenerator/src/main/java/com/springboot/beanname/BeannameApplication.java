package com.springboot.beanname;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeannameApplication {
    public static void main(String[] args) {
        //启动Spring Boot项目的唯一入口
        SpringApplication springApplication =new SpringApplication(BeannameApplication.class);
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
    }

}
