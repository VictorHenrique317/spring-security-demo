package com.example.springsecurity.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public enum AuthorizationType implements GrantedAuthority {
    STUDENT_READ("student:read"), // Must change @PreAuthorize values if this field is changed
    STUDENT_WRITE("student:write"), // Must change @PreAuthorize values if this field is changed
    COURSE_READ("course:read"), // Must change @PreAuthorize values if this field is changed
    COURSE_WRITE("course:write"); // Must change @PreAuthorize values if this field is changed

    private final String authority;


    @Override
    public String getAuthority() {
        return authority;
    }
}
