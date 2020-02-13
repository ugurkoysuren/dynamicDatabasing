package io.qimia.qimiagraphqlengine;

import io.qimia.qimiagraphqlengine.models.DBTypeEnum;
import io.qimia.qimiagraphqlengine.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);


    @Autowired
    private ClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("StartApplication...");
        saveBookswithMysql();

    }
    void saveBookswithMysql() {

        System.out.println("Done"+clientService.getClientName(DBTypeEnum.MYSQL));
    }
}
