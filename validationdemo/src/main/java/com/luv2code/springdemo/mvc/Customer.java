package com.luv2code.springdemo.mvc;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;
    
    @NotNull(message = "is Required")
    @Size(min=1,message = "is Required") //minimun 1 character should be there or it will give an error
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
