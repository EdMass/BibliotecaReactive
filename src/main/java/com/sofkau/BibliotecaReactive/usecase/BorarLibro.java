package com.sofkau.BibliotecaReactive.usecase;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface BorarLibro {
    public Mono<Void> get(String id);
}
