package com.msj.devbiblico.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
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

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

//    public User(Role role) {
//        if (this.role == null) {
//            this.role.setId(1l);
//        }
//    }
}
