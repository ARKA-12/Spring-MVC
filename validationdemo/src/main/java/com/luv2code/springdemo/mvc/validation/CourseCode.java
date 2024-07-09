package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy=CouseCodeConstraintValiadator.class) //helper class that contains business Logic
@Target({ElementType.FIELD, ElementType.METHOD}) // can apply this annotation to method or field
@Retention(RetentionPolicy.RUNTIME) // How long this marked annotation used --- Retain this annotation at byte code and use it at RUNTIME by JVM

public @interface CourseCode {

// define default course code

public String value() default "LUV";

//define the default error  message
public String message() default "must start with LUV";

//define default group
public Class <?>[] groups() default{}; // group the validation constraint together

// define default payloads
public Class<? extends Payload>[] payload() default {}; // for additional information about the validation

}
