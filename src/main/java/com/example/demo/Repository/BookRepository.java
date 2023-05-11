package com.example.demo.Repository;

import com.example.demo.Entity.Book;

import java.util.List;

public interface BookRepository{
    String ping();
    List<Book> getAll();
    int addBook(Book book);
    List<Book> findByName(String name);
}
