package com.hibernate.validator.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

/**
 * @author hz111
 * @create 2020-04-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    @Size(min = 1, max = 2)
    private Integer age;

}
