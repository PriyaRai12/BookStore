package com.bookstore.bookStore.repository;

import com.bookstore.bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository
        extends JpaRepository<Book, Long> {
}