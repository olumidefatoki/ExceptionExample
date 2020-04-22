package com.springboot.exception.example.repository;

import com.springboot.exception.example.exception.RecordNotFoundException;
import com.springboot.exception.example.model.Student;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {
    private final List<Student> studentList;

    public StudentRepository(List<Student> studentList) {
        this.studentList = studentList;
    }
    public Student insertStudent(Student student){
        studentList.add(student);
        return student;
    }
    public List<Student> getAllStudent() {
        return studentList;
    }
    public Student getStudentById(Long studentId){
       return studentList.stream()
                .filter(studentList -> studentId.equals(studentList.getId()))
                .findFirst()
                .orElseThrow(() -> new RecordNotFoundException("Student Id " + studentId + " is not found"));
    }

}
