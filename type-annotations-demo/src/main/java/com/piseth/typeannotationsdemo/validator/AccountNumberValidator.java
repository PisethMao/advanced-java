package com.piseth.typeannotationsdemo.validator;

import com.piseth.typeannotationsdemo.annotation.AccountNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements ConstraintValidator<AccountNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.matches("\\d{9,16}");
    }
}
