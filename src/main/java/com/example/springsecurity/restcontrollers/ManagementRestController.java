package com.example.springsecurity.restcontrollers;

import com.example.springsecurity.domain.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class ManagementRestController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_TRAINEE')")
    @GetMapping
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @PreAuthorize("hasAuthorization('student:write')")
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student);
    }

    @PreAuthorize("hasAuthorization('student:write')")
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId){
        System.out.println(studentId);
    }

    @PreAuthorize("hasAuthorization('student:write')")
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable int studentId,
                              @RequestBody Student student){
        System.out.println(studentId + " " + student);
    }
}
