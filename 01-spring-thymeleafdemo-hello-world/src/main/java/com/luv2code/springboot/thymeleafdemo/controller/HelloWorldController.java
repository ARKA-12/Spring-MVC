package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {


    //new controller method to show the initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    // need a controller method to process the form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloword-process";
    }

    // need a controller method to read form data and
    //data to the "Model"
    @RequestMapping("/processFormVersionTwo")
    public String letSoutDude(HttpServletRequest request,Model model){
        //read the request parameter from the HTML form
        String theName = request.getParameter("StudentName");
        //convert the data to all caps
        theName =theName.toUpperCase();
        //create the message
        String result = "Yo "+ theName;

        //add message to the Model

        model.addAttribute("message",result);


        

        return "helloword-process";
    }



    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("StudentName")String theName ,Model model){//here @RequestParam can access the HTML directly and store the data into theName
      
        //convert the data to all caps
        theName =theName.toUpperCase();
        //create the message
        String result = "HI, Buddy "+ theName;

        //add message to the Model

        model.addAttribute("message",result);


        

        return "helloword-process";
    }
}
