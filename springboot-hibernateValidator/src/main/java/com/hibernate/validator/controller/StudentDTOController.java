package com.hibernate.validator.controller;

import com.hibernate.validator.bean.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>测试简单的Student实体类对象属性验证 </p>
 *
 * @author hz
 * @create 2020-04-08
 */
@RestController
public class StudentDTOController {
    @RequestMapping("/studentValidator")
    public void studentValidator(@Valid Student student, BindingResult result) {
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
    }

}
