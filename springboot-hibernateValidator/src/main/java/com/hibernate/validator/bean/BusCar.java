package com.hibernate.validator.bean;

import com.hibernate.validator.annotation.ValidPassengerCount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author hz
 * @create 2020-04-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ValidPassengerCount(message = "学生乘客数量超过座位数")
public class BusCar {

    @Min(20)
    private int seatCount;

    private List<@Valid  Student> student;

}
