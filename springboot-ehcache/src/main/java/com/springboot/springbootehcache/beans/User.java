package com.springboot.springbootehcache.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hz
 * @create 2020-04-08
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    private String uuid;
    private String name;
    private String password;
    private String sex;
}
