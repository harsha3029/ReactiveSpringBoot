package com.application.webclient;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.application.datatransferobject.StudentDTO;

@Component
public class StudentClient {
	private final WebClient client;

	public StudentClient(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:8080").build();
	}

	public ResponseEntity<StudentDTO[]> findStudents() {
		return this.client.get().uri("/findStudents").accept(MediaType.APPLICATION_JSON).retrieve()
				.toEntity(StudentDTO[].class).block();
	}

	public void downloadCsv(String result) {
		this.client.get().uri("/exportCSV/?result=" + result).retrieve().toEntity(String.class).block();
	}

}
