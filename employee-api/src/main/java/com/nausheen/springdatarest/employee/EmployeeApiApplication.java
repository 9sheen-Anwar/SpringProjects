package com.nausheen.springdatarest.employee;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiApplication.class, args);
	}
	
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/restdb");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("sql");
		return dataSourceBuilder.build();
		
	}

}
