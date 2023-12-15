package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:dbConfig.properties")
public class DBConfiguration {
	@Autowired
	private Environment env;
	
	@Override
	public String toString() {
		return "userName:"+env.getProperty("user")
				+ ", password:"+env.getProperty("password");
	}

}
