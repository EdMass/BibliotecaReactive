package com.sofkau.BibliotecaReactive.usecase;

import com.sofkau.BibliotecaReactive.dto.BibliotecaDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ObtenerPorId {
    public Mono<BibliotecaDTO> get(String id);
}
