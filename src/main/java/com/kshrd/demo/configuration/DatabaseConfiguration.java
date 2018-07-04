package com.kshrd.demo.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {

	// Production DB
	@Bean
	public DataSource production() {
		DriverManagerDataSource db = new DriverManagerDataSource();
		db.setDriverClassName("org.postgresql.Driver");
		db.setUrl("jdbc:postgresql://localhost:5432/ams_sr");
		db.setUsername("postgres");
		db.setPassword("12345");
		return db;
	}
	
}
