# studyAll
1.记录 @Resource 和 @Autowired区别
2.测试对象单例多例情况。以及对象为单例，对象中的引用对象为多例时情况。
3.建立自己的 BeanNameGenerator 命名规则 对特定的包文件下所有文件使用使用
4.SpringBootApplication 有默认 ComponentScan扫描，
所以使用自定义命名规则时，需要排除，
否则分别会用默认和自定义规则 ComponentScan两次 造成 beanName出现两种命名或者重复报错
