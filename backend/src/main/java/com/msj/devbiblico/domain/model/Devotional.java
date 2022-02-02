package com.msj.devbiblico.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Devotional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String urlFoto;

    private String titulo;

    private String versiculo;

    private Integer capitulo;

    private String textoBiblico;

    @ManyToOne()
    private Book book;

    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;
}
