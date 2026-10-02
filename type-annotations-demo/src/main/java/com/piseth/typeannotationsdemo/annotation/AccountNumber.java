package com.piseth.typeannotationsdemo.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {
        com.piseth.typeannotationsdemo.validator.AccountNumberValidator.class
})
@Target({
        ElementType.TYPE_USE,
        ElementType.FIELD,
        ElementType.PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountNumber {
    String message() default "Invalid Account Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
