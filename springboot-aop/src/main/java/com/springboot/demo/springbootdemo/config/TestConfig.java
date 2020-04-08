package com.springboot.demo.springbootdemo.config;
import com.springboot.demo.springbootdemo.bean.Student;
import org.springframework.stereotype.Component;

/**
 * <p> </p>
 *
 * @author hz
 * @create 2020-04-07
 */
@Component
public class TestConfig {

    public static Student student;

    public  void print(){
        System.err.println("姓名"+student.getName());
    }

}
