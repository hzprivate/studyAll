# studyAll
1.学习 hibernateValidator的使用
官方文档地址：https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-class-level-constraints
    1.1 对象里的基本属性校验
    1.2 对象级联校验 例如对象中引用List对象
    1.3 校验错误：快速失败返回模式true 和普通返回模式false （default）
    1.4 实体类bean校验和 @RequestParam校验 的用法区别
    1.5 内置约束 选几个拿出来提示：
        1.5.1 @AssertFalse
              支持的数据类型 Boolean， boolean
        1.5.2 @Email 
              支持的数据类型 CharSequence
        1.5.3 @Max(value=) 检查带注释的值是否小于或等于指定的最大值
              支持的数据类型
              BigDecimal，BigInteger，byte，short，int，long和原始类型的相应的包装; HV额外支持：的任何子类型CharSequence（评估字符序列表示的数值），Number和的任何子类型javax.money.MonetaryAmount
        1.5.4 @Pattern(regex=, flags=，messgae=)
              regex考虑给定标志，检查带注释的字符串是否与正则表达式匹配match，
              支持的数据类型 CharSequence
        1.5.5 @PositiveOrZero
              检查元素是正数还是零。
              支持的数据类型 BigDecimal，BigInteger，byte，short，int，long和原始类型的相应的包装; HV额外支持：的任何子类型CharSequence（评估字符序列表示的数值），Number和的任何子类型javax.money.MonetaryAmount
        1.5.6 @Size(min=, max=)
              检查带注释的元素的大小是否介于min和之间max（包括）
              支持的数据类型
              CharSequence，Collection，Map和数组 （重点，不包括Integer）
        1.5.7 @Length(min=, max=) 验证该注释字符序列是间min和max包含
              支持的数据类型
              CharSequence
        1.5.8 @Range(min=, max=)
              检查带注释的值是否介于（包括）指定的最小值和最大值之间
              支持的数据类型
              BigDecimal，BigInteger，CharSequence，byte，short，int，long和原始类型的相应的包装
    1.6 创建自定义约束 
        1.6.1 创建自定义约束注解 
        1.6.2 实现ConstraintValidator接口的约束验证器  
        1.6.3 定义默认的错误提示                    