package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ch23Application{
	protected final Log logger=LogFactory.getLog(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(Ch23Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args->{
			logger.info("CommandLineRunner executed as a bean definition with "
					+ args.length+" arguments");
			
			for(int i=0;i<args.length;i++) {
				logger.info("Argument:"+args[i]);
			}
		};
	}
}
