package com.hz.functionInterface;

/**
 * 自定义函数接口
 * 一个函数接口 只能有一个抽象方法，可以含多个 非抽象方法
 * @author hz
 * @create 2020-11-06
 */
@FunctionalInterface
public interface ConsumerAnimal {
    void drink();
}
