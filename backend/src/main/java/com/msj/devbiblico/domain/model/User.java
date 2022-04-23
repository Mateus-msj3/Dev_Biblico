package com.msj.devbiblico.domain.model;

import com.msj.devbiblico.domain.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{username.obrigatorio}")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "{email.obrigatorio}")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "{password.obrigatorio}")
    @Column
    private String password;

    private RoleEnum role;

    public User() {
       if (role == null) {
           setRole(RoleEnum.ROLE_USER);
       }
    }

}
