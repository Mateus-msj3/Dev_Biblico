package com.msj.devbiblico.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProfileEnum name;
}
