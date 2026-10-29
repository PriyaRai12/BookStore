package com.bookstore.bookStore.service;

import com.bookstore.bookStore.entity.MyBook;
import com.bookstore.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepository myBookRepository;
    public void saveMyBook(MyBook book){
        myBookRepository.save(book);

    }

    public List<MyBook> getAllBook(){
        return myBookRepository.findAll();
    }
   public void deleteById(int id){
        myBookRepository.deleteById(id);
    }


}
