package com.glennon.inventory.configuration;

import com.glennon.inventory.controller.BeerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(DataBaseConfiguration.class);

    private static final String DB_SCRIPTS = "inventory_db/";
    private static final String DB_SCHEMA = "inventory_schema.sql";
    private static final String DB_TABLES = "inventory_data.sql";

    @Bean
    public DataSource inventoryDb() {
        EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase database = dbBuilder.setType(EmbeddedDatabaseType.H2)
                .addScript(DB_SCRIPTS + DB_SCHEMA)
                .addScript(DB_SCRIPTS + DB_TABLES)
                .build();
        return database;
    }

}
