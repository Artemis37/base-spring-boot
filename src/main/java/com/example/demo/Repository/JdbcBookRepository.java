package com.example.demo.Repository;

import com.example.demo.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcBookRepository implements BookRepository{

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcBookRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public String ping() {
        return "pong";
    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query("select * from book", (rs, rowNum) -> new Book(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDate("publish_date")
        ));
    }

    @Override
    public int addBook(Book book) {
        return jdbcTemplate.update("insert into book (`name`, `publish_date`) values(?, ?)", book.getName(), book.getPublishDate());
    }

    public List<Book> findByName(String name){
        try {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("name", "%" + name + "%");
            List<Book> result = namedParameterJdbcTemplate.query("select * from book where name like :name", mapSqlParameterSource, (rs, rowNum) -> new Book(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDate("publish_date")
            ));
            System.out.println(result);
            return  result;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<Book>();
        }
    }
}
