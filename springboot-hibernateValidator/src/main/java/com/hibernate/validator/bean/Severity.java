package com.hibernate.validator.bean;

import javax.validation.Payload;

/**
 * @author hz
 * @create 2020-04-29
 */
public class Severity {
    public interface Info extends Payload {
    }

    public interface Error extends Payload {
    }
}
