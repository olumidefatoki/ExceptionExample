package com.springboot.exception.example.controller;

import com.springboot.exception.example.model.Student;
import com.springboot.exception.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody  @Valid Student student){
      return   studentService.saveStudent(student);
    }
}
