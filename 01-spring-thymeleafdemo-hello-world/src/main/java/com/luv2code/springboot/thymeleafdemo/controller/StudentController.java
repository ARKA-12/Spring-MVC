package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2code.springboot.thymeleafdemo.Model.Student;

@Controller
public class StudentController {

    @Value("${countries}")
    List<String> Countries;

    @Value("${ProgrammingLanguages}")
    List<String> Languages;

    @Value("${OperatingSystem}")
    List<String> operatingSystem;


    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        //create a new student object

        Student theStudent = new Student();

        //add the student to the model

        theModel.addAttribute("student",theStudent);
        
        //adding countries to the Model
        theModel.addAttribute("countries",Countries); 

        //add the laguages in the model

        theModel.addAttribute("languages",Languages);

        //adding the opertating System data in the model

        theModel.addAttribute("operatingSystem",operatingSystem);
        

        return "student-form"; //always return HTML for now

}

@PostMapping("/processStudentForm")
public String processForm(@ModelAttribute("student") Student theStudent){

    //log the input data

    System.out.println("theStudent : "+theStudent.getFirstName()+ " "+theStudent.getLastName() );
    

    return "student-confirmation";
}

}
