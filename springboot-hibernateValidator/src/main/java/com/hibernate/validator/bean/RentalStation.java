package com.hibernate.validator.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author hz
 * @create 2020-04-30
 */
@Data
@AllArgsConstructor
@Builder
public class RentalStation {

    @NotNull(message = "集合不能为空")
    public List<Car> getAvailableCars() {
        //...
        return null;
    }

}
