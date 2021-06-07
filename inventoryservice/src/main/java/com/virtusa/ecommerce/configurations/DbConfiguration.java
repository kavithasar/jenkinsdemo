package com.virtusa.ecommerce.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data

public class DbConfiguration {
	
	@Value("${db_url}")	
	private String dbUrl;
	@Value("${db_driver}")
	private String driverName;
	@Value("${db_username}")
	   private String userName;
	   @Value("${db_password}")
		private String password;
	
	
	private DataSourceBuilder dataSourceBuilder;
	
	
	
	@Bean
	public DataSource getDataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		dataSourceBuilder.url(dbUrl);
		dataSourceBuilder.driverClassName(driverName);
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);
		return dataSourceBuilder.build();
		
	}
	
	

}
