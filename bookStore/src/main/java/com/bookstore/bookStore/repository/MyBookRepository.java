package com.bookstore.bookStore.repository;

import com.bookstore.bookStore.entity.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookRepository extends JpaRepository<MyBook,Integer> {
}
