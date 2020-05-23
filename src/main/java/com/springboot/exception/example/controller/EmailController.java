package com.springboot.exception.example.controller;

import com.springboot.exception.example.constant.CommonConstant;
import com.springboot.exception.example.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.ParseException;

@Controller
@RequestMapping("/email")
public class EmailController {
    @RequestMapping("/registration-email")
    public String registrationEmail(Model model) throws ParseException {
        Student student = new Student();
        student.setFirstName("Olumide");
        student.setLastName("Fatoki");
        student.setHeight(5.5);
        student.setWeight(80.5);
        student.setDepartment("Computer science");
        student.setEmail("Olumide.fatoki@gmail.com");
        model.addAttribute("student", student);
        return "student-registration";
    }
}
