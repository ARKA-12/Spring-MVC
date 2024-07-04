package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2code.springboot.thymeleafdemo.Model.Student;

@Controller
public class StudentController {


    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        //create a new student object

        Student theStudent = new Student();

        //add the student to the model

        theModel.addAttribute("student",theStudent);
        

        return "student-form"; //always return HTML for now

}

@PostMapping("/processStudentForm")
public String processForm(@ModelAttribute("student") Student theStudent){

    //log the input data

    System.out.println("theStudent : "+theStudent.getFirstName()+ " "+theStudent.getLastName() );

    return "student-confirmation";
}

}