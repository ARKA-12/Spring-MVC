package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerContoller {

    @GetMapping("/")
    public String showForm(Model theModel){ // model allows us to share the data between the controllers anf view pages(html pages --- thymeleaf)
        
        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processCustomerForm")

    public String processForm(@Valid @ModelAttribute("customer") Customer thecustomer,BindingResult theBindingResult){

        //@Valid --Tell Spring MVC to perform validation
        //@ModelAttribute -- Read the form data form model aattribute customer when user submitted the form
        //bindingResult -- Hold the result of the validation.

        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        else{

            return "customer-confirmation-form";
        }
    }
}
