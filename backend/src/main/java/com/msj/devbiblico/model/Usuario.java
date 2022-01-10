package com.msj.devbiblico.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nome"),
        @UniqueConstraint(columnNames = "email")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_perfil",
                joinColumns = @JoinColumn(name = "id_usuario"),
                inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private Set<Perfil> perfils = new HashSet<>();
}
