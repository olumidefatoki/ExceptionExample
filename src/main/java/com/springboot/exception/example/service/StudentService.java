package com.springboot.exception.example.service;

import com.springboot.exception.example.exception.DuplicateRecordException;
import com.springboot.exception.example.model.Student;
import com.springboot.exception.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    MailService mailService;

    @Value("${escrow.transaction.subject.email}")
    String emailSubject;
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        if (isRecordExist(student))
            throw new DuplicateRecordException("Duplicate Record already Exist");
        Student repoResponse = studentRepository.insertStudent(student);
        mailService.sendEmailNotification(student, emailSubject);
        return repoResponse;
    }

    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    private boolean isRecordExist(Student student) {
        return studentRepository.getAllStudent().stream()
                .filter(studentList -> student.getId().equals(studentList.getId()))
                .findFirst()
                .isPresent();
    }

}
