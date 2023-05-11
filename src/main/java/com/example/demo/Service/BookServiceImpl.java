package com.example.demo.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Repository.JpaBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

//    @Autowired
    BookRepository jdbcBookRepository;
    JpaBookRepository jpaBookRepository;

    @Autowired
    public BookServiceImpl(BookRepository jdbcBookRepository, JpaBookRepository jpaBookRepository) {
        this.jdbcBookRepository = jdbcBookRepository;
        this.jpaBookRepository = jpaBookRepository;
    }

    public List<Book> getAll() {
//        jdbc:
//        return jdbcBookRepository.getAll();

//        jpa:
        return  com.google.common.collect.Lists.newArrayList(jpaBookRepository.findAll());
    }

    @Override
    public int addBook(Book book) {
//        jdbc:
//        return jdbcBookRepository.addBook(book);

//        jpa:
        try{
            return jpaBookRepository.save(book) != null ? 1 : 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Book> findByName(String name) {
        return jdbcBookRepository.findByName(name);
    }
}
