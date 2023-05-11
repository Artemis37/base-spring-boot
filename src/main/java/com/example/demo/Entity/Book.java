package com.example.demo.Entity;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Date publishDate;

    public Book() {
    }

    public Book(String name, Date publishDate) {
        this.name = name;
        this.publishDate = publishDate;
    }
    public Book(int id, String name, Date publishDate) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", publishDate=" + sdf.format(publishDate) +
                '}';
    }
}
