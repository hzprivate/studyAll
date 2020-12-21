package com.hz.test;

import com.hz.functionInterface.ConsumerAnimal;
import com.hz.util.MyList;

import java.util.*;

/**
 * 测试lambda的应用
 * @author hz
 * @create 2020-11-06
 */
public class LambdaTest {

    public static void invoke(ConsumerAnimal consumeAnimal){
        consumeAnimal.drink();
    }
    public static void main(String[] args) {
        //1. 测试普通集合 lambda遍历
//        List<Integer> list = Arrays.asList(10,2,9,8);
//        list.forEach(System.out::println);
        //        //equals
//        list.forEach((p) -> System.out.println(p));

        //2.测试简单自定义  void函数接口
//        invoke(()-> System.out.println("测试自定义 函数接口"));
        //equals
//        invoke(new ConsumerAnimal() {
//            @Override
//            public void drink() {
//
//            }
//        });
        //2.1 测试复杂自定义函数接口  逻辑：对List集合中所有含有2 的数据元素替换位 *
//        List<String> listString = Arrays.asList("2","10","9","8");
//        MyList.replace2X(listString,(oldString,newString)->oldString.replace(oldString,newString));
//        System.out.println(listString);

        //3.测试函数接口排序
//          List<Integer> list = Arrays.asList(10,2,9,8);
//        Collections.sort(list, Integer::compareTo);
        //equals  3.1
//        Collections.sort(list,(o1,o2)->o1.compareTo(o2));
        //equals  3.2
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        System.out.println(list);

    }
}
