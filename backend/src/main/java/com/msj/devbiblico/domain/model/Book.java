package com.msj.devbiblico.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data

public class Book {

    private Abbrev abbrev;

    private String name;

    private String author;

    private Integer chapters;

    private String testament;

    private Chapter chapter;

    private List<Verse> verses = new ArrayList<Verse>();

}
