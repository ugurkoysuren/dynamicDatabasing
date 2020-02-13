package io.qimia.qimiagraphqlengine.models;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Database access code for datasource routing example.
 */
public class ClientDao {

    private static final String SQL_GET_CLIENT_NAME = "SELECT *\n" +
            "  FROM information_schema.columns\n" +
            " WHERE table_schema = 'public'\n" +
            "   AND table_name   = 'account'\n" +
            "     ;";

    private final JdbcTemplate jdbcTemplate;

    public ClientDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    public String getClientName() {
        return this.jdbcTemplate.query(SQL_GET_CLIENT_NAME, rowMapper).get(0);
    }

    private static RowMapper<String> rowMapper = (rs, rowNum) -> {
        return rs.getString("column_name");
    };
}
