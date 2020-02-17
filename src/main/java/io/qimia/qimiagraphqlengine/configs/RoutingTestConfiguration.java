package io.qimia.qimiagraphqlengine.configs;

import io.qimia.qimiagraphqlengine.models.ClientDao;
import io.qimia.qimiagraphqlengine.models.DBTypeEnum;
import io.qimia.qimiagraphqlengine.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RoutingTestConfiguration {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Autowired
    public ClientService clientService() {
        return new ClientService(new ClientDao(clientDatasource()));
    }

    @Bean
    public DataSource clientDatasource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.POSTGRESQL,postgresqlSource());
        targetDataSources.put(DBTypeEnum.MYSQL,mysqlDataSource());
        ClientDataSourceRouter clientRoutingDatasource
                = new ClientDataSourceRouter();
        clientRoutingDatasource.setTargetDataSources(targetDataSources);
        clientRoutingDatasource.setDefaultTargetDataSource(targetDataSources.get(DBTypeEnum.POSTGRESQL));
        return clientRoutingDatasource;
    }

    public DataSource mysqlDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/mysql2");
        dataSourceBuilder.username("db_user");
        dataSourceBuilder.password("P@s$w0rd123!");
        return dataSourceBuilder.build();
    }

    public DataSource postgresqlSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("myPassword");
        return dataSourceBuilder.build();
    }
}
