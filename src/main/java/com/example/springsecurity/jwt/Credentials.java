package com.example.springsecurity.jwt;

import lombok.*;

@Getter @Setter
@EqualsAndHashCode(of = {"username", "password"})
@NoArgsConstructor
public class Credentials {
    private String username;
    private String password;
}
