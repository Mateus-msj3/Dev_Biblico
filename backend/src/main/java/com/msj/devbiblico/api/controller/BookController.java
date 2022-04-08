package com.msj.devbiblico.api.controller;

import com.msj.devbiblico.domain.model.Book;
import com.msj.devbiblico.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private String url = "https://www.abibliadigital.com.br/api/books";

    @Autowired
    private BookService bookService;

    @GetMapping("/teste")
    public ResponseEntity<Book> getBook() {
        Book book = bookService.allBooks();

        return book != null ? ResponseEntity.ok().body(book) : ResponseEntity.notFound().build();
    }


}
