package com.sofkau.BibliotecaReactive.routers;

import com.sofkau.BibliotecaReactive.dto.BibliotecaDTO;
import com.sofkau.BibliotecaReactive.usecase.UseCaseAgregarUnLibro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AgregarLibroRouter {
    @Bean
    public RouterFunction<ServerResponse> agregarUnLibro(UseCaseAgregarUnLibro useCaseAgregarUnRecurso ) {
        return route(POST("/library/agregarLibro").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BibliotecaDTO.class)
                        .flatMap(recursoDTO -> useCaseAgregarUnRecurso.apply(recursoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
