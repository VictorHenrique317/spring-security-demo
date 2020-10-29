package com.example.springsecurity.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Student {
    private int studentId;
    private String studentName;
}
