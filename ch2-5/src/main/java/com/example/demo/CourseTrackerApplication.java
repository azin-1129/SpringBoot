package com.example.demo;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.example.demo.model.Course;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class CourseTrackerApplication implements CommandLineRunner {
	private static Logger logger=
			LoggerFactory.getLogger(CourseTrackerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CourseTrackerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Course course=new Course();
		course.setId(1);
		course.setRating(0);
		
		Validator validator=
				Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<Course>> violations=
				validator.validate(course);
		
		violations.forEach(courseConstraintViolation->
				logger.error("A constraint violation has occurred."
						+ " Violation details:[{}].", courseConstraintViolation));

	}

}
