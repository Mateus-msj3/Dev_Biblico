package com.msj.devbiblico.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PerfilEnum name;
}
