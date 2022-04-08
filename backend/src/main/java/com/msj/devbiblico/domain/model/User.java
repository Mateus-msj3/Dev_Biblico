package com.msj.devbiblico.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles")
    private Set<Integer> roles = new HashSet<>();

    public User() {
        addRole(RoleEnum.USER);
    }

    //converte minha coleção de inteiros para o tipo do perfil do Enum
    public Set<RoleEnum> getRoleEnum() {
        return roles.stream().map(role -> RoleEnum.toEnum(role)).collect(Collectors.toSet());
    }

    public void addRole(RoleEnum roleEnum) {
        roles.add(roleEnum.getCode());
    }

}
