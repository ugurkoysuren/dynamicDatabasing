package io.qimia.qimiagraphqlengine;

import io.qimia.qimiagraphqlengine.models.DBTypeEnum;
import io.qimia.qimiagraphqlengine.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    @Autowired
    private ClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Done"+clientService.getClientName(DBTypeEnum.POSTGRESQL));

    }
}
