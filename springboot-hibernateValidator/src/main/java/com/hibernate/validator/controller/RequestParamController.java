package com.hibernate.validator.controller;

import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Pattern;

/**
 * <p>测试 RequestParam 校验验证 </p>
 *
 * @author hz
 * @create 2020-04-28
 */
@RestController
@Validated
public class RequestParamController {
    private Logger logger = LoggerFactory.getLogger(RequestParamController.class);
    /**
     * 通过 统一捕捉ConstraintViolationException异常，返回错误messgae信息
     * @param name
     * @param age
     */
    @RequestMapping("/testRequestParam")
    public void testValidator(@NotBlank(message="姓名不能为空") String name,@Pattern(regexp="^[0-9]{1,2}$",message="年龄不正确") String age) {


    }
}
