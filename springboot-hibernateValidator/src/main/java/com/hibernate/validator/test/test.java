package com.hibernate.validator.test;

import com.hibernate.validator.bean.Student;
import com.hibernate.validator.bean.Teacher;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 单元测试 hibernate validator
 * @author hz
 * @create 2020-04-21
 */
public class test {
    /**
     * failFast：true  快速失败返回模式    false 普通模式
     * @return
     */
    private static Validator  getValidator(){
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure()
                .failFast(false)
                .buildValidatorFactory();
       return validatorFactory.getValidator();
    }

    /**
     * 测试单个对象验证
     */
    public static void test1(){
        Student student = new Student();
        Student build = student.builder().name("").age("").build();
        Set<ConstraintViolation<Student>> validate = getValidator().validate(build);
        Iterator<ConstraintViolation<Student>> iterator = validate.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getMessage());
        }
    }

    /**
     * 测试级联验证
     */
    public static void test2(){
        Student build1 = Student.builder().name("").age("").build();
        Student build2 = Student.builder().name("sd").age("140").build();
        List<Student> list = new ArrayList<>();
        list.add(build1);
        list.add(build2);
        Teacher teacher = Teacher.builder().name("张三").age("22").student(list).build();
        Set<ConstraintViolation<Teacher>> validate = getValidator().validate(teacher);
        Iterator<ConstraintViolation<Teacher>> iterator = validate.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getMessage());
        }
    }

    public static void main(String[] args) {
        test2();
    }
}
