package com.springboot.globalexception.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>测试 RequestParam 校验验证 </p>
 *
 * @author hz
 * @create 2020-04-28
 */
@RestController
public class DemoTestController {
    private Logger logger = LoggerFactory.getLogger(DemoTestController.class);
    /**
     * 通过 统一捕捉ConstraintViolationException异常，返回错误messgae信息
     */
    @RequestMapping("/testRequestParam")
    public void testValidator() {


    }
}
