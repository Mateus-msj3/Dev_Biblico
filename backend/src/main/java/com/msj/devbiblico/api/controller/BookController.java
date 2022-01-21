package com.msj.devbiblico.api.controller;

import com.msj.devbiblico.domain.model.Book;
import com.msj.devbiblico.domain.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    @GetMapping("/{id}")
//    public Book findById(@PathVariable Long id) {
//        return bookService.bookId(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book book = bookService.bookId(id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        book = bookService.alterBook(book);
        return ResponseEntity.ok(book);
    }
}
