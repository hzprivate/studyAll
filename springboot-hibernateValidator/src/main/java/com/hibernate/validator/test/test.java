package com.hibernate.validator.test;

import com.hibernate.validator.bean.Student;

/**
 * @author hz
 * @create 2020-04-21
 */
public class test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("黄");
        student.setAge(120);
        System.out.println(student);
    }
}
