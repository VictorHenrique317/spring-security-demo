package com.example.springsecurity.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Table(name = "Authorities")
@Entity
@Setter
@EqualsAndHashCode(of = "authority")
public class AuthorityEntity implements GrantedAuthority {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
