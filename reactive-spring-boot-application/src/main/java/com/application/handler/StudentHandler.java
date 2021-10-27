package com.application.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.application.datatransferobject.StudentDTO;

import reactor.core.publisher.Mono;

@Component
public class StudentHandler {

	public Mono<ServerResponse> getAllStudents(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(new StudentDTO().getStudents()));
	}

}