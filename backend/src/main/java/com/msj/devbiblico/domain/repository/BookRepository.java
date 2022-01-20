package com.msj.devbiblico.domain.repository;

import com.msj.devbiblico.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
