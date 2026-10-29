package com.bookstore.bookStore.controller;

import com.bookstore.bookStore.entity.Book;
import com.bookstore.bookStore.entity.MyBook;
import com.bookstore.bookStore.service.BookService;
import com.bookstore.bookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private MyBookService myBookService;
    @Autowired
    private BookService service;
    @GetMapping({"/home"})
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String register(){
        return "register_book";
    }
    @GetMapping("/available_book")
    public ModelAndView available(){
        List<Book> list=service.getAllBook();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("available_book");
        modelAndView.addObject("book",list);
        return modelAndView;
    }
    @PostMapping("/save")
    public String addList(@ModelAttribute Book b){
        service.save(b);

//        Book book = null;
        System.out.println(b.getAuthor());
        System.out.println(b.getName());
        System.out.println(b.getPrice());
        return "redirect:/available_book";
    }

    @GetMapping({"/mybook","/my_book"})
    public String myBook(Model model){
        List<MyBook>list=myBookService.getAllBook();
        model.addAttribute("book",list);
        return "mybook";
    }

//    @RequestMapping("/mylist/{id}")
//    public String getMyList(@PathVariable("id") int id){
//        Book b=service.getBookById(id);
//       MyBook myBook=new MyBook();
//        myBookService.saveMyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
//        return "redirect:/mybook";
//    }

//@RequestMapping("/mylist/{id}")
//public String getMyList(@PathVariable("id") int id){
//    Book b = service.getBookById(id);
//
//    // Ek nayi MyBook object banao aur Book ka data usme daalo
//    MyBook myBook = new MyBook(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
//
//    // Ab service ke method me ye object pass kar do
//    myBookService.saveMyBook(myBook);
//
//    return "redirect:/mybook";
//}

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = service.getBookById(id);

        MyBook myBook = new MyBook();
        // ID ko null chhod do taaki naya record auto-increment hokar save ho
        myBook.setName(b.getName());
        myBook.setAuthor(b.getAuthor());
        myBook.setPrice(b.getPrice());

        myBookService.saveMyBook(myBook);

        return "redirect:/mybook";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){

       Book b= service.getBookById(id);
       model.addAttribute("book",b);
        return "edit";
    }
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {

        service.deleteBookById(id);

        return "redirect:/available_book";
    }
}
