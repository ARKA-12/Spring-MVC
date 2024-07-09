package com.luv2code.springdemo.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;

    @NotNull(message = "is Required")
    @Size(min=1,message = "is Required") //minimun 1 character should be there or it will give an error
    private String lastName;

    @Min(value=0,message="must be greater than or equal to 0")
    @Max(value=10,message ="must be less than or equal to 10")
    private int freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message = "must be 5 chras/digits")
    private String postalCode;


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

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
}
