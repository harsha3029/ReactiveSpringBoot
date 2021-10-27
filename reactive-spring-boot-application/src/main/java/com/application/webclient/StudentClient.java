package com.application.webclient;


import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.application.datatransferobject.StudentDTO;

@Component
public class StudentClient {
	 private final WebClient client;

	  public StudentClient(WebClient.Builder builder) {
	    this.client = builder.baseUrl("http://localhost:8080").build();
	  }

	  public Mono<String> findStudents() {
	    return this.client.get().uri("/findStudents").accept(MediaType.APPLICATION_JSON)
	        .retrieve()
	        .bodyToMono(StudentDTO.class)
	        .map(StudentDTO::toString);
	  }
}
