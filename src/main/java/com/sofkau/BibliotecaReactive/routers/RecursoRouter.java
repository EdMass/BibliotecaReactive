package com.sofkau.BibliotecaReactive.routers;

import com.sofkau.BibliotecaReactive.dto.BibliotecaDTO;
import com.sofkau.BibliotecaReactive.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> modificarUnLibro(UseCaseModificarLibro useCaseModificarRecurso ) {
        return route(PUT("/library/modificarLibro").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BibliotecaDTO.class)
                        .flatMap(recursoDTO -> useCaseModificarRecurso.apply(recursoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }



}
