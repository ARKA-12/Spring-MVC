package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CouseCodeConstraintValiadator implements  ConstraintValidator<CourseCode, String> {

    public String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode){
        coursePrefix =theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
    
        boolean result;

        if(theCode!=null){
          result= theCode.startsWith(coursePrefix); //checking the its take the first valuse as the default value or not

        }
        else{
            return true;
        }


        return result;

    }

}
