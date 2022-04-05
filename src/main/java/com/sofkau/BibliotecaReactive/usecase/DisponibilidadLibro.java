package com.sofkau.BibliotecaReactive.usecase;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DisponibilidadLibro {
    public Mono<String> apply(String titulo);
}
