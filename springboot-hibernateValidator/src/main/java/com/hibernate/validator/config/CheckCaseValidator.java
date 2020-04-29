package com.hibernate.validator.config;

import com.hibernate.validator.annotation.CheckCase;
import com.hibernate.validator.constant.CaseMode;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author hz
 * @create 2020-04-29
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, CharSequence> {
    /**
     * ConstraintValidator<CheckCase,String>
     * 第一个指定要验证的注解类型（CheckCase），
     * 第二个指定验证器可以处理的元素的类型（String）
     * 如果约束条件支持几种数据类型，
     * 则必须ConstraintValidator为每种允许的类型实现，并在约束条件注解处进行注册，如上所述。
     */
    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        caseMode=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(CharSequence object, ConstraintValidatorContext constraintContext) {
        if ( object == null ) {
            //参数可以为null
            return true;
        }
        if ( caseMode == CaseMode.UPPER ) {
           return object.equals( object.toString().toUpperCase() );
        }
        else {
            return object.equals( object.toString().toLowerCase() );
        }

    }
}
