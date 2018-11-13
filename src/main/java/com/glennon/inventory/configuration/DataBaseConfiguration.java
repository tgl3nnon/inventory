package com.glennon.inventory.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by T. Glennon
 */

@Configuration
public class DataBaseConfiguration {
    private static final String DB_SCRIPTS = "inventory_db/";

    @Bean
    public DataSource inventoryDb() {
        EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase database = dbBuilder.setType(EmbeddedDatabaseType.H2)
                .addScript(DB_SCRIPTS + "inventory_schema.sql")
                .build();
        return database;
    }

}
