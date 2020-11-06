package com.hz.test;

/**
 * lambda 表达式。开启Runable线程
 * @author hz
 * @create 2020-11-06
 */
public class LamRunable{

    public static void main(String[] args) {
        new Thread(()-> {
            System.out.println("2222");

        }, "sad").start();
    }
}
