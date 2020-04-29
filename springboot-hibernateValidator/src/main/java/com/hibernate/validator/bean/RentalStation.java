package com.hibernate.validator.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author hz
 * @create 2020-04-29
 */
@Data
@NoArgsConstructor
@Builder
public class RentalStation {


    public void rentCar(
            @NotNull String name,
            @Min(1) int age) {
        System.out.println(name+","+age);
    }
}
