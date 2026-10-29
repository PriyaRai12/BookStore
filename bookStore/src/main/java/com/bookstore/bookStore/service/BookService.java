package com.bookstore.bookStore.service;

import com.bookstore.bookStore.entity.Book;
import com.bookstore.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
//    @Autowired
    public void save(Book b){
        bookRepository.save(b);
    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById((long) id).get();
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById((long) id);
    }
}
