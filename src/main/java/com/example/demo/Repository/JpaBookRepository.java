package com.example.demo.Repository;

import com.example.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository extends JpaRepository<Book, Integer> {
}
