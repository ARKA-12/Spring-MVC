package com.luv2code.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerContoller {

    //Add @initBinder -- to convert trim input strings(basically remove the whitespace)
    //resolve issue for validation it remove the leading and trailing whitespace.

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        //here String.class means-- apply for all String where spring find a white space it will remove it.
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        

    }


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

        System.out.println("Last Name: |"+ thecustomer.getLastName()+" |");

        System.out.println("Binding result: "+ theBindingResult.toString());

        System.out.println("\n\n\n\n");

        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        else{

            return "customer-confirmation-form";
        }
    }
}
