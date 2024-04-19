package com.cstad.itebankingprojectdemo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @ManyToMany
    private List<Authority> authorities;

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + "]";
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + name; // Role_admin, Role_staff
    }
}
