package com.example.demo.Controller;

import com.example.demo.Entity.Book;
import com.example.demo.Service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public List<Book> getBooks() {
        return bookService.getAll();
    }

    @GetMapping("/addBook")
    public int addBook() {
        Book newBook = new Book("Tom Cruise in deserted island", new Date());
        return bookService.addBook(newBook);
    }

    @GetMapping("/findByName")
    public List<Book> findByName(@RequestParam("name") String bookname) {
        return bookService.findByName(bookname);
    }

}
