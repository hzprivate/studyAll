package com.hibernate.validator.config;

import com.hibernate.validator.annotation.ValidPassengerCount;
import com.hibernate.validator.bean.BusCar;
import com.hibernate.validator.constant.CaseMode;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义ValidPassengerCount注解约束验证器
 * @author hz
 * @create 2020-04-29
 */
public class VaildPassengerCountValidator implements ConstraintValidator<ValidPassengerCount, BusCar> {
    /**
     * ConstraintValidator<ValidPassengerCount,BusCar>
     * 第一个指定要验证的注解类型（ValidPassengerCount），
     * 第二个指定验证器可以处理的元素的类型（BusCar）
     * 如果约束条件支持几种数据类型，
     * 则必须ConstraintValidator为每种允许的类型实现，并在约束条件注解处进行注册，如上所述。
     */


    @Override
    public void initialize(ValidPassengerCount constraintAnnotation) {
    }

    @Override
    public boolean isValid(BusCar busCar, ConstraintValidatorContext constraintContext) {
        if ( busCar == null ) {
            //参数可以为null
            return true;
        }
        if(StringUtils.isEmpty(busCar.getStudent())){
            return true;
        }
        return busCar.getStudent().size()<=busCar.getSeatCount();
    }
}
