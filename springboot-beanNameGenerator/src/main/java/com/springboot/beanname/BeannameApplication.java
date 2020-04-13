package com.springboot.beanname;

import com.springboot.beanname.filter.MyTypeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@SpringBootApplication //（相当于如下三个注解）
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)})
public class BeannameApplication {
    public static void main(String[] args) {
        //启动Spring Boot项目的唯一入口
        SpringApplication springApplication =new SpringApplication(BeannameApplication.class);
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
    }

}
