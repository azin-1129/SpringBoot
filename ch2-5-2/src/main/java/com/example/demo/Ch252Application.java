package com.example.demo;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;
@SpringBootApplication
public class Ch252Application implements CommandLineRunner{
	private static Logger logger = LoggerFactory.getLogger(Ch252Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Ch252Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user1=new User("sbip01", "sbip");
		
		Validator validator=Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<User>> violations=validator.validate(user1);
		
		logger.error("Password for user1 do not adhere to the password policy.");
		
		violations.forEach(constraintViolation ->
				logger.error("Violation details:[{}].",
						constraintViolation.getMessage()));
		
		User user2 = new User("sbip02", "Sbip01$4UDfg");
        violations = validator.validate(user2);
        if(violations.isEmpty()) {
            logger.info("Password for user2 adhere to the password policy");
        }

        User user3 = new User("sbip03", "Sbip01$4UDfgggg");
        violations = validator.validate(user3);
        logger.error("Password for user3 violates maximum repetitive rule");
        violations.forEach(constraintViolation -> logger.error("Violation details: [{}].", constraintViolation.getMessage()));

        User user4 = new User("sbip04", "Sbip014UDfgggg");
        violations = validator.validate(user4);
        logger.error("Password for user4 violates special character rule");
        violations.forEach(constraintViolation -> logger.error("Violation details: [{}].", constraintViolation.getMessage()));
	}

}
