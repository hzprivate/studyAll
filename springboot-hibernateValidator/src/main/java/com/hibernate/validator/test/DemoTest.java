package com.hibernate.validator.test;

import com.hibernate.validator.common.Util;
import com.hibernate.validator.bean.*;
import org.hibernate.validator.HibernateValidator;
import javax.validation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 单元测试 hibernate validator
 * @author hz
 * @create 2020-04-28
 */
public class DemoTest {
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
     * 测试单个bean验证
     */
    public static void test1(){
        Student build = Student.builder().name("ss").age("124").build();
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
        Teacher teacher = Teacher.builder().name("张三").student(list).build();
        System.out.println(Util.objToJson(teacher));
        Set<ConstraintViolation<Teacher>> validate = getValidator().validate(teacher);
        Iterator<ConstraintViolation<Teacher>> iterator = validate.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getMessage());
        }
    }
    /**
     * 测试分组约束 根据分组验证
     */
    public static void test3(){
        Car car = Car.builder().seatCount(1).safetyBelt(false).build();
        Validator validator = getValidator();
        //测试默认default组
//        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        //测试SafeCheck组
        Set<ConstraintViolation<Car>>  constraintViolations = validator.validate( car, SafeCheck.class );
        Iterator<ConstraintViolation<Car>> iterator = constraintViolations.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getMessage());
        }
    }

    /**
     * 测试自定义约束
     */
    public static void test4(){
        Car car = Car.builder().safetyBelt(true).seatCount(2).licensePlate("qaed").build();
        Validator validator = getValidator();
        Set<ConstraintViolation<Car>>  constraintViolations = validator.validate(car);
        Iterator<ConstraintViolation<Car>> iterator = constraintViolations.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getMessage());
        }

    }

    /**
     * 测试自定义 类级别约束
     */
    public static void test5(){
        List<Student> studentList = new ArrayList<>();
        Student student = Student.builder().age("40").name("hz").build();
        for (int i = 0; i < 30; i++) {
            studentList.add(student);
        }
        BusCar busCar = BusCar.builder().seatCount(20).student(studentList).build();
        Set<ConstraintViolation<BusCar>>  constraintViolations = getValidator().validate(busCar);
        Iterator<ConstraintViolation<BusCar>> iterator = constraintViolations.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getMessage());
        }

    }

    /**
     * 测试方法级别约束
     */
    public static void test6(){
        RentalStation rentalStation = RentalStation.builder().build();
        List<Car> availableCars = rentalStation.getAvailableCars();

        Set<ConstraintViolation<RentalStation>>  constraintViolations = getValidator().validate(rentalStation);
        Iterator<ConstraintViolation<RentalStation>> iterator = constraintViolations.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getMessage());
        }

    }


    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }

}
