# lambda-test 记录lambda使用
1. lambda语法结构参数列表、箭头、声明语句（可根据情况省略）      
  (Type1 param1, Type2 param2, ..., TypeN paramN) -> { statment1; statment2; //............. return statmentM;}
     最终可省略至 -> ()->statment;
2. lambda 常用函数式接口 Comparator，Runable，Callable等以及java.util.function（函数接口包）
    - Predicate——接收T对象并返回boolean

    - Consumer——接收T对象，不返回值

    - Function——接收T对象，返回R对象

    - Supplier——提供T对象（例如工厂），不接收值
3. Animal.java 自定义函数接口
4. 方法引用语法：
    - names2. forEach(System.out::println); //equals // names2. forEach(s->System.out.println(s));
    - 
4. Stream 对lambda中的应用
    - Stream 不是 集合元素，也不是数据结构，它相当于一个 高级版本的 Iterator，不可以重复遍历里面的数据，像水一样，流过了就一去不复返。它和普通的 Iterator 不同的是，它可以并行遍历，普通的 Iterator 只能是串行，在一个线程中执行。操作包括：中间操作 和 最终操作(只能操作一遍) 串行流操作在一个线程中依次完成。并行流在多个线程中完成，主要利用了 JDK7 的 Fork/Join 框架来拆分任务和加速处理。相比串行流，并行流可以很大程度提高程序的效率
 

