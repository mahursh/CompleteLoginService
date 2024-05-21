package com.mft.completeloginservice.controller.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.HashMap;
import java.util.Map;

public class BeanValidation<T>{

    // TODO: Try Catch
    public Map<String,String> validate(T t){
         ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
         Validator validator = validatorFactory.getValidator();

        Map<String,String> errors = new HashMap<>();

         for (ConstraintViolation<T> violation : validator.validate(t)) {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
         return (errors.isEmpty()) ? null : errors;
     }
}
