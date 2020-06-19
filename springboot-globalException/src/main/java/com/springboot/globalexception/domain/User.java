package com.springboot.globalexception.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hz
 * @create 2020-04-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private Integer age;
}
