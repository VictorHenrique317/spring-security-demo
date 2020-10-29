package com.example.springsecurity.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

import static com.example.springsecurity.security.AuthorizationType.*;

@AllArgsConstructor
@Getter
public enum RoleType {
    STUDENT(new HashSet<>()), // Must change @PreAuthorize values if this field is changed
    ADMIN(Set.of(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE)), // Must change @PreAuthorize values if this field is changed
    ADMIN_TRAINEE(Set.of(STUDENT_READ, COURSE_READ)); // Must change @PreAuthorize values if this field is changed

    private final Set<AuthorizationType> authorities;

    public String getFullRoleName(){
        return "ROLE_" + this.name();
    }

    public String getPartialRoleName(){
        return this.name();
    }

}
