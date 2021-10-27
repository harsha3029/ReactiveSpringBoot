package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;

import com.application.datatransferobject.StudentDTO;
import com.application.webclient.StudentClient;

@SpringBootApplication
public class ReactiveSpringBootApp {

	static ResponseEntity<StudentDTO[]> result;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReactiveSpringBootApp.class, args);
		StudentClient studentClient = context.getBean(StudentClient.class);
		result = studentClient.findStudents();
		StudentDTO[] body = result.getBody();
		for (StudentDTO dto : body) {
			sb.append(dto.getFirstName()).append(":").append(dto.getLastName()).append(":").append(dto.getAddress())
					.append(":").append(dto.getEmailId()).append(":").append(dto.getPhoneNumber())
					.append("\n");
		}
		studentClient.downloadCsv(sb.toString());

	}

}
