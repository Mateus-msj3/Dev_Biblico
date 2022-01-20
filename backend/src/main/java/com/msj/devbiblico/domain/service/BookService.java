package com.msj.devbiblico.domain.service;

import com.msj.devbiblico.domain.exception.EntidadeNaoEncontradaException;
import com.msj.devbiblico.domain.model.Book;
import com.msj.devbiblico.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> allBooks() {
        return  bookRepository.findAll();
    }

    public Book bookId(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            return book.get();
        }
        return book.orElseThrow(()-> new EntidadeNaoEncontradaException("Livro não encotrado"));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
