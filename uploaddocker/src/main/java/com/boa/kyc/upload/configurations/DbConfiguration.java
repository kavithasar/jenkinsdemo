package com.boa.kyc.upload.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
//configuration successful
@Configuration
@Data
@Slf4j
//@EnableConfigurationProperties(VaultConfiguration.class)

public class DbConfiguration {
    @Value("${db_url}")
	private String url;    
   @Value("${db_username}")
   private String userName;
   @Value("${db_password}")
	private String password;
    @Value("${db_driver}")
	private String driver;
    private DataSourceBuilder dataSourceBuilder;
    
    
    
    
    @Bean
    //@Profile("prod")
    public DataSource getDataSource()
    {
    	//log.info("Entering Production Env.....");
    	//log.info("User Name..."+vaultConfiguration.getUsername());
    	//log.info("User Name..."+vaultConfiguration.getPassword());
    	dataSourceBuilder=DataSourceBuilder.create();
    	dataSourceBuilder.url(url);
    	dataSourceBuilder.username(userName);
    	dataSourceBuilder.password(password);
    	dataSourceBuilder.driverClassName(driver);
    	return dataSourceBuilder.build();
   	
    }
    
	
	
}
