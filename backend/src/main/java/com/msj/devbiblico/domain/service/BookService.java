package com.msj.devbiblico.domain.service;

import com.msj.devbiblico.domain.exception.ObjectNotFoundException;
import com.msj.devbiblico.domain.model.Book;
import com.msj.devbiblico.domain.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return book.orElseThrow(()-> new ObjectNotFoundException("Livro não encontrado"));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book alterBook(Book book) {
        Optional<Book> currentBook = bookRepository.findById(book.getId());
        if (currentBook.isPresent()) {
            BeanUtils.copyProperties(book, currentBook.get(), "id");
        }
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        try {
            bookRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException("Livro não encontrado");
        }
    }

}
