package io.qimia.qimiagraphqlengine;

import io.qimia.qimiagraphqlengine.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("StartApplication...");
        saveBookswithMysql();

    }
    void saveBookswithMysql() {

        jdbcTemplate.execute("DROP TABLE IF EXISTS book_image");
        jdbcTemplate.execute("CREATE TABLE book_image(" +
                "id INT, book   _id INT, filename VARCHAR(255),blob_image VARCHAR(255))");
        bookRepository.saveBook(1L,"test","test2");
        bookRepository.saveBook(1L,"test1","test12");
        bookRepository.saveBook(1L,"test2","test22");
        System.out.println("Done");
    }
}
