package com.msj.devbiblico.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String autor;

    @Enumerated(EnumType.STRING)
    private LocalizacaoEnum localizacao;

    private Integer quantidadeCapitulos;


}
