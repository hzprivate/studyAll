package com.hibernate.validator.annotation;

import com.hibernate.validator.config.VaildPassengerCountValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author hz
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = { VaildPassengerCountValidator.class})
@Documented
public @interface ValidPassengerCount {

    String message() default "{com.hibernate.validator.annotation.ValidPassengerCount." +
            "message}";

    Class<?>[] groups() default { };//分组验证。默认分组default

    Class<? extends Payload>[] payload() default { }; //有效负载 （例如不同地区之间实现不同的邮编等）
}
