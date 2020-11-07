package com.hz.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试集中常用的Stream流操作
 * @author hz
 * @Description:
 * @create 2020-11-07
 */
public class StreamTest {
    public static void main(String[] args) {
        //filter 过滤  map 上色 collect 拿出
        //1. collect(toList()) 终止操作
        List<String> collect = Arrays.asList("21", "23").stream().collect(Collectors.toList());
        System.out.println("collect终止操作："+ collect);
        //2.filter 中间操作
        String[] testStrings = { "java", "react", "angular", "vue" };
        List<String> j = Stream.of(testStrings).filter(s -> s.contains("j")).collect(Collectors.toList());
        System.out.println("map中间操作："+ j);
        //3. map中间操作
        List<String> upcase = Stream.of(testStrings).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("map中间操作："+ upcase);
        //4. reduce 终止操作
        Optional<Integer> count = Arrays.asList(1, 2, 3, 4, 5).stream().reduce(Integer::sum);
        System.out.println(count.get());
        //5. max 终止操作
        Optional<Integer> max = Arrays.asList(1, 2, 3, 4, 5).stream().max(Integer::compareTo);
        System.out.println(max.get());

    }
}
