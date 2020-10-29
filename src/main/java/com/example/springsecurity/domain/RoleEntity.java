package com.example.springsecurity.domain;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "Roles")
@Entity
@Setter
@EqualsAndHashCode(of = "role")
public class RoleEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;

    @Getter
    @JoinTable(name = "authorities_per_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AuthorityEntity> authorities;

    public String getRoleName() {
        return role;
    }
}
