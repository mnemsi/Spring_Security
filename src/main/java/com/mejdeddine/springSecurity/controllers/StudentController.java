package com.mejdeddine.springSecurity.controllers;


import com.mejdeddine.springSecurity.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(new Student(1,"homa"),
                                                                new Student(2,"houmani"));
    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) throws IllegalStateException {
        return STUDENTS.stream()
                        .filter(student->student.getStudentId()==studentId)
                        .findFirst().orElseThrow(()->new IllegalStateException("Student not Found" + studentId));
    }
}
