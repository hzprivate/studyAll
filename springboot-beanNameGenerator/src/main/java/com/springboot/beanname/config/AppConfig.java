package com.springboot.beanname.config;

import com.springboot.beanname.generator.MyNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hz
 * @create 2020-04-10
 */
@Configuration
@ComponentScan(basePackages = "com.springboot.beanname.bean.bean1",nameGenerator = MyNameGenerator.class)
public class AppConfig {
//    @Bean
//    public  Student student() {
//        return new Student();
//    }
}
