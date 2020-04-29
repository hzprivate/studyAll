package com.springboot.beanname.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author hz
 * @create 2020-04-21
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String>  list = new ArrayList<>();
        List<String>  list1 = new ArrayList<>();
        list.add("s");
        list.add("2");
        list.add("3");
        list.add("4");
//        for (String s : list) {
//            System.out.println(s);
//            if(s.equals("2")){
//                list.remove("2");
//            }
//        }
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }

    }
}
