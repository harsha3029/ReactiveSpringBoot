package com.application.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.application.handler.StudentHandler;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class StudentRouter {

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	@Bean
	public RouterFunction<ServerResponse> route(StudentHandler studentHandler) {

		return RouterFunctions.route(GET("/findStudents").and(accept(MediaType.APPLICATION_JSON)),
				studentHandler::getAllStudents);
				

	}

}
