package com.hibernate.validator.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 、快速失败返回模式
 * 　　快速失败返回模式(只要有一个验证失败，则返回)
 *
 * 两种验证模式配置方式：（参考官方文档）
 *
 * failFast：true  快速失败返回模式    false 普通模式
 *
 * ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
 *         .configure()
 *         .failFast( true )
 *         .buildValidatorFactory();
 * Validator validator = validatorFactory.getValidator();
 * 和 （hibernate.validator.fail_fast：true  快速失败返回模式    false 普通模式）
 *
 * ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
 *         .configure()
 *         .addProperty( "hibernate.validator.fail_fast", "true" )
 *         .buildValidatorFactory();
 * Validator validator = validatorFactory.getValidator();
 *
 * @author hz
 * @create 2020-04-27
 */

@Configuration
public class ValidatorConfiguration {
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                .failFast( true )
              .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator;
    }
}
