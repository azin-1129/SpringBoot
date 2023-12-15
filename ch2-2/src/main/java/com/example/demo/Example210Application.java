package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Example210Application {
	private static final Logger log=
			LoggerFactory.getLogger(Example210Application.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=
				SpringApplication.run(Example210Application.class, args);
//		Environment env=applicationContext.getBean(Environment.class);
//		
//		log.info(env.getProperty("app.timeout"));
		
		AppService appService=
				applicationContext.getBean(AppService.class);
		
		log.info(appService.getAppProperties().toString());
	}

}
