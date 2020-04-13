# springboot-beanNameGenerator @service等未命名的组件生成bean name时使用自定义beanNameGenerator

1.记录 @Resource 和 @Autowired区别
2.测试bean对象单例、多例情况。以及对象为单例，对象中的引用对象为多例时情况。
3.使用自己的 BeanNameGenerator 命名规则针对特定的包文件下所有类
4.SpringBootApplication 有默认 ComponentScan扫描注解，
所以使用自定义命名规则时，需要排除，
否则分别会用默认和自定义规则 ComponentScan扫描两次，生成两个bean对象甚至beanName重复报错
