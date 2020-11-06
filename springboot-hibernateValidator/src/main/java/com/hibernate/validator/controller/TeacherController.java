package com.hibernate.validator.controller;

import com.hibernate.validator.bean.Teacher;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>测试 级联校验Teacher bean对象属性</p>
 *
 * @author hz
 * @create 2020-04-28
 */
@RestController
public class TeacherController {
    @RequestMapping("/testTeacher")
    public String teacherController(@RequestBody @Valid Teacher teacher, BindingResult result) {
        String message="success";
        if(result.hasErrors()){
            message=result.getAllErrors().get(0).getDefaultMessage();
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
        return message;
    }

}
