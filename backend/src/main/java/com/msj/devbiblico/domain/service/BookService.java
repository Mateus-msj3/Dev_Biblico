package com.msj.devbiblico.domain.service;

import com.msj.devbiblico.domain.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(url= "https://www.abibliadigital.com.br/api/books", name = "books")
public interface BookService {

    @GetMapping()
    Book allBooks();

}
