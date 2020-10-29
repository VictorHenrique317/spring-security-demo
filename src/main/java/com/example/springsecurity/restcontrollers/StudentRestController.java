package com.example.springsecurity.restcontrollers;

import com.example.springsecurity.domain.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return STUDENTS.stream()
                .filter((student)-> student.getStudentId() == studentId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Student with id "+ studentId + " does not exit"));
    }
}
