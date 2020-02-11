package io.qimia.qimiagraphqlengine.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveBook(Long bookId, String name, String name2) {
            jdbcTemplate.update(
                    "INSERT INTO book_image (book_id, filename, blob_image) VALUES (?, ?, ?)",bookId,name,name2);
    }
}
