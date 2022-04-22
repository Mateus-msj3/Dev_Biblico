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

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "roles")
//    private Set<Integer> roles = new HashSet<>();

    public User() {
       if (role == null) {
           setRole(RoleEnum.ROLE_USER);
       }

    }

//    //converte minha coleção de inteiros para o tipo do perfil do Enum
//    public Set<ProfileEnum> getRoleEnum() {
//        return roles.stream().map(role -> ProfileEnum.toEnum(role)).collect(Collectors.toSet());
//    }
//
//    public void addRole(ProfileEnum roleEnum) {
//        roles.add(roleEnum.getCode());
//    }

}
