package com.Dispatcher;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.Controller,com.ResultSetExtractor,com.StudentService")
public class Configuration1 implements WebMvcConfigurer{
	
    @Bean
    public InternalResourceViewResolver  resolver1() {
    	   
	    InternalResourceViewResolver  resolver = new InternalResourceViewResolver();
    	    resolver.setPrefix("/WEB-INF/view/");
            resolver.setSuffix(".jsp");
            return resolver;
        }
	
	@Bean
	public JdbcTemplate jdbctemplate() {
		
		JdbcTemplate  jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public DataSource  dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/school1?useSSL=false"); 
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return dataSource;
	}
	
	
	
	
	
	
	
	

}
