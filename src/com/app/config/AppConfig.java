package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@ComponentScan(basePackages = { "com.app" })
public class AppConfig {

	@Bean
	public OracleDataSource dataSource() {

		OracleDataSource dataSource = null;
		try {
			System.out.println("here is dat source");
			dataSource = new OracleDataSource();
			dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setUser("pushp_1");
			dataSource.setPassword("pushp_1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
//
//	@Bean
//	public StudentDao studentDao() {
//		return new StudentDaoImpl();
//	}
//
//	@Bean
//	public StudentService studentService() {
//		return new StudentServiceImpl();
//	}
//	
//	@Bean
//	public StudentController studentController() {
//		return new StudentControllerImpl();
//	}
}
