package com.springboot.globalexception.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hz
 * @create 2020-04-30
 */
@AllArgsConstructor
@Getter
public enum  ResponseEnum {
    /**
     * Bad user type
     */
    BAD_USER_TYPE(7001, "Bad user type."),
    /**
     * User not found
     */
    USER_NOT_FOUND(7002, "User not found.")
    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}
