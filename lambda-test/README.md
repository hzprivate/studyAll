# lambda-test 记录lambda使用
1. lambda语法结构参数列表、箭头、声明语句（可根据情况省略）      
  (Type1 param1, Type2 param2, ..., TypeN paramN) -> { statment1; statment2; //............. return statmentM;}
     最终可省略至 ()->statment;
2. lambda 常用函数式接口 Comparator，Runable，Callable等以及java.util.function（函数接口包）
    - Predicate——接收T对象并返回boolean

    - Consumer——接收T对象，不返回值

    - Function——接收T对象，返回R对象

    - Supplier——提供T对象（例如工厂），不接收值
3. Animal.java 自定义简单函数接口   ; FunctionReplaceList.java 模拟Comparator.compare() 方法 自定义复杂函数接口
4. 方法引用语法：
    - names2. forEach(System.out::println); //equals // names2. forEach(s->System.out.println(s));
4. Stream 对lambda中的应用
    - Stream 不是 集合元素，也不是数据结构，它相当于一个 高级版本的 Iterator，不可以重复遍历里面的数据，像水一样，流过了就一去不复返。它和普通的 Iterator 不同的是，它可以并行遍历，普通的 Iterator 只能是串行，在一个线程中执行。操作包括：中间操作 和 最终操作(只能操作一遍) 串行流操作在一个线程中依次完成。并行流在多个线程中完成，主要利用了 JDK7 的 Fork/Join 框架来拆分任务和加速处理。相比串行流，并行流可以很大程度提高程序的效率
    - 对Stream的操作分为三类： 
        - 1.创建stream
        - 2.中间操作(没有终止操作不会执行) ：会返回另一个流，可以用链式编程的形式继续调用
        - 3.终止操作 ：不会返回流，而是返回结果： void或int 或list集合等
        
    - 常用的Stream流操作
        - 1.collect(toList()) 终止操作：由Stream中的值生成一个List列表，也可用collect(toSet())生成一个Set集合。
		List<String> list = Stream.of(testStrings).collect(Collectors.toList());
        - 2.map 中间操作：将一种类型的值映射为另一种类型的值，可以将 Stream 中的每个值都映射为一个新的值，最终转换为一个新的 Stream 流。
		List<String> list = Stream.of(testStrings).map(test -> test.toUpperCase()).collect(Collectors.toList());
        - 3.filter 中间操作 ：遍历并筛选出满足条件的元素形成一个新的 Stream 流。
		long count = list.stream().filter(p -> p.startsWith("j")).count();
		- 4.flatMap 中间操作：可用 Stream 替换值，并将多个 Stream 流合并成一个 Stream 流。
		List<Integer> list = (List<Integer>) Stream.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(8, 9, 10, 11, 12))
        				.flatMap(test -> test.stream()).collect(Collectors.toList());
        - 5.max 、min 终止操作:求 Stream 中的最大值、最小值。
		Optional<String> max = Stream.of(testStrings).max((p1, p2) -> Integer.compare(p1.length(), p2.length()));
        - 6.reduce 终止操作:从 Stream 的一组值中生成另一个值。上述的max、min、count 实际上都是 reduce 操作


