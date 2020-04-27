package com.hibernate.validator.controller;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Pattern;

/**
 * <p>测试 RequestParam 参数校验 </p>
 *
 * @author hz
 * @create 2020-04-08
 */
@RestController
@Validated
public class RequestParamController {
    /**
     * 通过 统一捕捉ConstraintViolationException异常，返回错误messgae信息
     * @param name
     * @param age
     */
    @RequestMapping("/testValidator")
    public void testValidator(@NotBlank(message="姓名不能为空") String name,@Pattern(regexp="^[0-9]{1,2}$",message="年龄不正确") String age) {


    }

}
