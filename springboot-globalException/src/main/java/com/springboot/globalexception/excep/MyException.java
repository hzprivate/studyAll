package com.springboot.globalexception.excep;

/**
 * @author hz
 * @create 2020-06-02
 */
public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
    public MyException(String message,Throwable cause) {
        super(message, cause);
    }
}
