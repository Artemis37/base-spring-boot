package com.example.demo.Service;

import com.example.demo.Entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    int addBook(Book book);

    List<Book> findByName(String name);
}
