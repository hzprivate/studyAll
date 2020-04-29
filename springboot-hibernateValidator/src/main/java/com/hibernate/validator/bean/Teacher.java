package com.hibernate.validator.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author hz
 * @create 2020-04-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @NotBlank(message="teacher姓名不能为空")
    private String name;

    @Pattern(regexp="^[0-9]{1,2}$",message="teacher年龄不正确")
    private String age;

    private List<@Valid  Student> student;

}