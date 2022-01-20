package com.msj.devbiblico.api.controller;

import com.msj.devbiblico.domain.model.Book;
import com.msj.devbiblico.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("http://localhost:4200/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> all() {
        return bookService.allBooks();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.bookId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return bookService.createBook(book);
    }
}
