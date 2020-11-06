package com.hibernate.validator.bean;

import com.hibernate.validator.annotation.CheckCase;
import com.hibernate.validator.constant.CaseMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * @author hz
 * @create 2020-04-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {


    @NotNull
    @Range(min = 2, max = 14,message = "座位个数不符合要求")
    /**
     * 座位数
     * 由于未为此注释指定任何组，因此采用默认组 javax.validation.groups.Default
     */
    private Integer seatCount;


    /**
     * 安全带
     * 采用 SafeCheck 组 ，SafeCheck简单标记接口。如果该接口extends Default 则同为默认组
     */
    @AssertTrue(
            message = "汽车没有安全带",
            groups = SafeCheck.class
    )
    private boolean safetyBelt;

    /**
     * 车牌照
     */
    @CheckCase(value = CaseMode.UPPER,message = "车牌号字母必须大写")
    private String licensePlate;

}
