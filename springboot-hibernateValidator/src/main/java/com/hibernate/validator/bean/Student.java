package com.hibernate.validator.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author hz
 * @create 2020-04-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @NotBlank(message="student姓名不能为空")
    private String name;


    @Pattern(regexp="^[0-9]{1,2}$",message="student年龄不正确")
    private String age;

}
