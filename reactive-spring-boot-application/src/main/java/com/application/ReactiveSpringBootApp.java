package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.application.webclient.StudentClient;

@SpringBootApplication
public class ReactiveSpringBootApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReactiveSpringBootApp.class, args);
		StudentClient studentClient = context.getBean(StudentClient.class);
		System.out.println(studentClient.findStudents().block());

	}

}
